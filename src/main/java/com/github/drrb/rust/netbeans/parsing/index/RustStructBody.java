/**
 * Copyright (C) 2017 drrb
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.drrb.rust.netbeans.parsing.index;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.netbeans.modules.csl.api.OffsetRange;

/**
 *
 */
public class RustStructBody {

    private final OffsetRange offsetRange;
    private final List<RustStructField> fields;

    RustStructBody(OffsetRange offsetRange, List<RustStructField> fields) {
        this.offsetRange = offsetRange;
        this.fields = Collections.unmodifiableList(fields);
    }

    public String toString() {
        StringBuilder sb= new StringBuilder();
        for (Iterator<RustStructField> it=fields.iterator(); it.hasNext();) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public OffsetRange getOffsetRange() {
        return offsetRange;
    }

    public List<RustStructField> getFields() {
        return Collections.unmodifiableList(fields);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private OffsetRange offsetRange;
        private List<RustStructField> fields = new LinkedList<>();

        public RustStructBody build() {
            return new RustStructBody(offsetRange, fields);
        }

        public Builder setOffsetRange(OffsetRange offsetRange) {
            this.offsetRange = offsetRange;
            return this;
        }

        public Builder addField(RustStructField field) {
            this.fields.add(field);
            return this;
        }
    }
}
