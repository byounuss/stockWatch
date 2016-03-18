@sample_StockList
Feature: Nifty top 50 stock list
	1.Check if %Chng is correctly calculated based on opening value and the change
	2.Check if %Chng column is in descending order for all rows (except for NIFTY 50)
	3.Check if the advances and declines summarized at the top match with the 50 rows of the table. An advance is a positive %Chng and a decline is a negative %Chng

  Scenario: Go to cukes.info
    Given I am on "https://www1.nseindia.com/live_market/dynaContent/live_watch/equities_stock_watch.htm"
    And Verify the Stocklsit page loaded properly
    Then Verify Open Chng and %Chng columns are present
    And Verify %Chng calculated curreclty
    And Verify Make sure that %Chng displayed in descending order1
#    And Verify that advances, declines and Unchanged count match exaclty and total count should be 50
    
  