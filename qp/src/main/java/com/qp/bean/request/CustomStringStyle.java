package com.qp.bean.request;

import org.apache.commons.lang.builder.ToStringStyle;


public final class CustomStringStyle extends ToStringStyle {

    private static final long serialVersionUID = 1L;

    /**
     * <p>Constructor.</p>
     *
     * <p>Use the static constant rather than instantiating.</p>
     */
    public CustomStringStyle() {
        super();
        this.setUseShortClassName(false);
        this.setUseIdentityHashCode(false);
    }

    /**
     * <p>Ensure <code>Singleton</ode> after serialization.</p>
     * @return the singleton
     */
    private Object readResolve() {
        return ToStringStyle.SHORT_PREFIX_STYLE;
    }

}

