package com.gridnine.testing.filters;

import com.gridnine.testing.test.Flight;

public interface Filter {
    boolean check(Flight flight);
}
