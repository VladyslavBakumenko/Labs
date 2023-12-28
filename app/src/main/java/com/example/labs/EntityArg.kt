package com.example.labs

data class EntityArg(var entity: Application? = null) {

    companion object {
        private var instance: EntityArg? = null
        fun getInstance(entity: Application? = null): EntityArg {
            instance = EntityArg(entity)
            return instance!!
        }

        fun justGetInstance(): EntityArg? {
            return instance
        }
    }
}