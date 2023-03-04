Feature: To validate the account creation of fb appliction

Scenario: To create new account
Given To launch the browser and maximise the window
When To launch url of fb apppliction
And To click the create new account button
And To pass Firstname in Firstname text box
# key       value
|firstname1|siva|
|firstname2|janani|
|firstname3|sangeetha|
|firstname4|peneal|


And To pass secoundname in secoundname text box
And To pass mobileno  or email in email text box

|password1|password2|password3|
|989392923|djdjdsdjf||djdjsjwwwk|
|esjdjkdkdk|sangeethadds||83833939283|
|nsmakjejs|djdkekekdd|ejksdkkkd|




And To create new password using new password text box
Then To close the chrome browser

