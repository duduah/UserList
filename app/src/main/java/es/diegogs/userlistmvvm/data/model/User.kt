package es.diegogs.userlistmvvm.data.model

data class User (
        val name: Name,
        val picture: Picture
)

data class Name (
        val last: String
)

data class Picture (
        val large: String,
        val medium: String,
        val thumbnail: String
)