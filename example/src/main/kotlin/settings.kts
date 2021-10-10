import com.paperlark.projector.syntax.*

instanceGroup(name = "test") {
    instance(
        host = "localhost"
    )
}

containerGroup(name = "postgres") {
    dockerContainer(
        name = "quizzical_swanson"
    )
}
