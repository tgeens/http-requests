package com.budjb.httprequests.converter

interface EntityReader extends EntityConverter {
    /**
     * Determines if the reader supports converting an entity to the given class type.
     *
     * @param type Type to convert to.
     * @return Whether the type is supported.
     */
    boolean supports(Class<?> type)

    /**
     * Convert the given entity.
     *
     * If an error occurs, null may be returned so that another converter can attempt a conversion.
     *
     * @param entity Entity as an {@link InputStream}.
     * @param contentType Content-Type of the entity.
     * @param charset Character set of the entity.
     * @return The converted entity.
     * @throws Exception when an unexpected error occurs during conversion.
     */
    Object read(InputStream entity, String contentType, String charset) throws Exception
}
