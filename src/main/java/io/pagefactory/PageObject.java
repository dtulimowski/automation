package io.jobee.pagefactory;

import com.github.metalloid.core.Metalloid;

public class PageObject {
    public PageObject() {
        Metalloid.initializePage(this);
    }
}
