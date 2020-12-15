/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.Internal.*;
import static org.jooq.impl.Keywords.*;
import static org.jooq.impl.Names.*;
import static org.jooq.impl.SQLDataType.*;
import static org.jooq.impl.Tools.*;
import static org.jooq.impl.Tools.BooleanDataKey.*;
import static org.jooq.SQLDialect.*;

import org.jooq.*;
import org.jooq.impl.*;
import org.jooq.tools.*;

import java.util.*;


/**
 * The <code>XMLFOREST</code> statement.
 */
@SuppressWarnings({ "rawtypes", "unused" })
final class Xmlforest
extends
    AbstractField<XML>
{

    private static final long serialVersionUID = 1L;

    private final Collection<? extends Field<?>> fields;

    Xmlforest(
        Collection<? extends Field<?>> fields
    ) {
        super(
            N_XMLFOREST,
            allNotNull(XML)
        );

        this.fields = fields;
    }

    // -------------------------------------------------------------------------
    // XXX: QueryPart API
    // -------------------------------------------------------------------------



    @Override
    public final void accept(Context<?> ctx) {
        boolean declareFields = ctx.declareFields();
        Object previous = ctx.data(DATA_AS_REQUIRED, true);

        ctx.visit(N_XMLFOREST).sql('(')
           .declareFields(true)
           .visit(new SelectFieldList<>(fields))
           .declareFields(declareFields)
           .sql(')');

        ctx.data(DATA_AS_REQUIRED, previous);
    }



    // -------------------------------------------------------------------------
    // The Object API
    // -------------------------------------------------------------------------

    @Override
    public boolean equals(Object that) {
        if (that instanceof Xmlforest) {
            return
                StringUtils.equals(fields, ((Xmlforest) that).fields)
            ;
        }
        else
            return super.equals(that);
    }
}
