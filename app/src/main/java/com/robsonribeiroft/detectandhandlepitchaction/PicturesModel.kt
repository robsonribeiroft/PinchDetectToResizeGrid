package com.robsonribeiroft.detectandhandlepitchaction

data class PicturesModel(
    val url: String
) {
    companion object {
        fun fakeList(): List<PicturesModel> = (0..1024).map {
            PicturesModel(
                url = "PICTURE Nº$it of the list"
            )
        }
    }
}
