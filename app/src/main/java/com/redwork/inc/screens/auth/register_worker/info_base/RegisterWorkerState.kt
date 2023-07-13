package com.redwork.inc.screens.auth.register_worker.info_base

data class RegisterWorkerState(
    val name: String = "",
    val lastname: String = "",
    val email: String = "",
    val phone: String = "",
    val role: MutableList<String> = mutableListOf()
)