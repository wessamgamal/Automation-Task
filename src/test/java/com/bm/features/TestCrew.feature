Feature: subscription Packages || countries
  Scenario Outline: Validate Subscription Packages Type , currency and amount for specific country

    Given User navigated to website "<URL>"
    Given validate subscription Details is as expected for specific "<country>"
    Then Close the website
    Examples:
      | URL          | country|
      |https://subscribe.stctv.com/kw-en|kw|
      |https://subscribe.stctv.com/sa-en|sa|
      |https://subscribe.stctv.com/bh-en|bh|


