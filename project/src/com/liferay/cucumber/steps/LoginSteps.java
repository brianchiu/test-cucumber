/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class LoginSteps {

    @When("^I log in as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void login(String emailAddress, String password) throws Exception {
        _loginPageObject.login(emailAddress, password);
    }

    @Then("^I logout$")
    public void logout() throws Exception {
    	_loginPageObject.logout();
    }

    private LoginPageObject _loginPageObject = new LoginPageObject();
}