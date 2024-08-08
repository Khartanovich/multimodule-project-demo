package com.example.core.utils

interface DelegateItem {
    fun id(): Any = hashCode()

    fun content(): Any = this

    fun payload(other: Any): List<Payloadable> = listOf()

    fun getLayoutId(): Int = 0

    interface Payloadable
}