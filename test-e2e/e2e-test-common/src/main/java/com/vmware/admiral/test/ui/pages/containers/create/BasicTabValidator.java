/*
 * Copyright (c) 2018 VMware, Inc. All Rights Reserved.
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with separate copyright notices
 * and license terms. Your use of these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 */

package com.vmware.admiral.test.ui.pages.containers.create;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;

import com.vmware.admiral.test.ui.pages.common.PageValidator;

public class BasicTabValidator extends PageValidator<BasicTabLocators> {

    public BasicTabValidator(By[] iFrameLocators, BasicTabLocators pageLocators) {
        super(iFrameLocators, pageLocators);
    }

    private final String INPUT_ERROR_CLASS = "has-error";

    @Override
    public void validateIsCurrentPage() {
        element(locators().basicTabButton()).shouldHave(Condition.cssClass("active"));
    }

    public void validateEmptyNameFieldError() {
        element(locators().nameInputWrapper()).shouldHave(Condition.cssClass(INPUT_ERROR_CLASS));
        element(locators().nameInputWrapper()).shouldHave(Condition.text("Value is required"));
    }

    public void validateInvalidNameError() {
        element(locators().nameInputWrapper()).shouldHave(Condition.cssClass(INPUT_ERROR_CLASS));
        element(locators().nameInputWrapper())
                .shouldHave(Condition.text("Invalid container name"));
    }

}