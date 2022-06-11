package com.example.unflowcarousel

data class Block (
    val position: Int,
    val value: String,
    val style: Map<String, String>,
    val blockType: BlockType,
)

enum class BlockType {
    IMAGE,
    TEXT,
}

enum class BlockTextStyle(val style: String) {
    LG("lg"),
    XL("xl"),
}