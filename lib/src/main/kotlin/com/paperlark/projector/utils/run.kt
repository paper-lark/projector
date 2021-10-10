package com.paperlark.projector.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.BufferedReader

fun runCommandAsync(cmd: String): Flow<String> {
    val proc = Runtime.getRuntime().exec(cmd)
    return channelFlow {
        coroutineScope {
            val reader = BufferedReader(proc.inputStream.reader())
            launch(Dispatchers.IO) {
                var line: String? = reader.readLine()
                while (line != null) {
                    send(line)
                    line = reader.readLine()
                }

                val code = proc.waitFor()
                if (code != 0) {
                    val err = BufferedReader(proc.errorStream.reader()).readLine()
                    throw RuntimeException("command '$cmd' returned with code=$code: $err")
                }
            }
        }
    }
}

suspend fun runCommand(cmd: String): String {
    val result = StringBuilder()
    runCommandAsync(cmd).collect {
        result.append(it)
        result.append("\n")
    }
    return result.toString()
}
