package com.alura.domain.enum

enum class VideoCategory(val tagName: String) {

    MOBILE("Mobile"),
    PROGRAMMING("Programming"),
    FRONT_ENT("Front End"),
    DATA_SCIENCE("Data Science"),
    DEVOPS("Devops"),
    UX_DESIGN("UX & Design");

    companion object {
        fun fromName(categoryName: String): VideoCategory {
            val category = VideoCategory.values().find { it.tagName == categoryName }
            if (category!=null){
                return category
            }

            throw EnumConstantNotPresentException(VideoCategory::class.java, categoryName)
        }
    }

}