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

import cucumber.api.java.en.When;

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class PageSteps {
	@When("I add a page named \"([^\"]*)\"$")
	public void addPage(String pageName) throws Exception {
		_pagePageObject.addPage(pageName);
	}

	@When("I navigate to the page named \"([^\"]*)\"$")
	public void gotoPage(String pageName) throws Exception {
		_pagePageObject.gotoPage(pageName);
	}

	private PagePageObject _pagePageObject = new PagePageObject();
}
