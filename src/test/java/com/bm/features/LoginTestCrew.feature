Feature: Login

  Scenario Outline: navigation to Website URL

    Given User navigated to website "<URL>"

    Examples:
      | URL          |
      |https://subscribe.stctv.com/kw-en|
      |https://subscribe.stctv.com/sa-en|
      |https://subscribe.stctv.com/bh-en|
