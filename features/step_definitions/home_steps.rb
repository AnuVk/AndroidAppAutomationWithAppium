Given(/^I have launched the app$/) do
    sleep 5

end

Then(/^I should see the Home screen$/) do
   wait = Selenium::WebDriver::Wait.new(:timeout => 3)
   wait.until{find_element(:uiautomator, 'new UiSelector().text("Android automation using Appium!")')}
    # text('Android automation using Appium!')
end
