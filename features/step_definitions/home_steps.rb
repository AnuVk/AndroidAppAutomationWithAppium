Given(/^I have launched the app$/) do
    sleep 5

end

Then(/^I should see the Home screen$/) do
    text('Android automation using Appium!')
end
