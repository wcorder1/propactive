package io.github.propactive.type

import io.github.propactive.type.Type.Companion.INVALID
import io.github.propactive.type.Type.Companion.VALID
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

/** JSON type as defined by [RFC 8259](https://datatracker.ietf.org/doc/html/rfc8259) */
object JSON : Type {
    override fun validate(value: Any) = value
        .runCatching { Json.decodeFromString<JsonObject>(toString()); VALID }
        .getOrDefault(INVALID)
}