/*
 * This file is generated by jOOQ.
*/
package com.the9o.demo.jooq.models;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.customer_id_seq</code>
     */
    public static final Sequence<Long> CUSTOMER_ID_SEQ = new SequenceImpl<Long>("customer_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
