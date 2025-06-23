Feature: Gilded Rose quality
  I want to know if the quality is updated properly

  Scenario: Normal item before sell date
    Given An item named "foo" with sellIn 10 and quality 20
    When I update the quality
    Then The item should have sellIn 9 and quality 19

  Scenario: Normal item on sell date
    Given An item named "foo" with sellIn 0 and quality 20
    When I update the quality
    Then The item should have sellIn -1 and quality 18

  Scenario: Normal item after sell date
    Given An item named "foo" with sellIn -1 and quality 20
    When I update the quality
    Then The item should have sellIn -2 and quality 18

  Scenario: Normal item quality never negative
    Given An item named "foo" with sellIn 5 and quality 0
    When I update the quality
    Then The item should have sellIn 4 and quality 0

  Scenario: Aged Brie increases in quality
    Given An item named "Aged Brie" with sellIn 2 and quality 0
    When I update the quality
    Then The item should have sellIn 1 and quality 1

  Scenario: Aged Brie quality never more than 50
    Given An item named "Aged Brie" with sellIn 2 and quality 50
    When I update the quality
    Then The item should have sellIn 1 and quality 50

  Scenario: Sulfuras never decreases in quality or sellIn
    Given An item named "Sulfuras, Hand of Ragnaros" with sellIn 0 and quality 80
    When I update the quality
    Then The item should have sellIn 0 and quality 80

  Scenario: Backstage passes long before concert
    Given An item named "Backstage passes to a TAFKAL80ETC concert" with sellIn 15 and quality 20
    When I update the quality
    Then The item should have sellIn 14 and quality 21

  Scenario: Backstage passes close to concert (10 days)
    Given An item named "Backstage passes to a TAFKAL80ETC concert" with sellIn 10 and quality 20
    When I update the quality
    Then The item should have sellIn 9 and quality 22

  Scenario: Backstage passes very close to concert (5 days)
    Given An item named "Backstage passes to a TAFKAL80ETC concert" with sellIn 5 and quality 20
    When I update the quality
    Then The item should have sellIn 4 and quality 23

  Scenario: Backstage passes after concert
    Given An item named "Backstage passes to a TAFKAL80ETC concert" with sellIn 0 and quality 20
    When I update the quality
    Then The item should have sellIn -1 and quality 0

  Scenario: Backstage passes quality never more than 50
    Given An item named "Backstage passes to a TAFKAL80ETC concert" with sellIn 5 and quality 50
    When I update the quality
    Then The item should have sellIn 4 and quality 50

  Scenario: Conjured item before sell date
    Given An item named "Conjured" with sellIn 10 and quality 20
    When I update the quality
    Then The item should have sellIn 9 and quality 18

  Scenario: Conjured item on sell date
    Given An item named "Conjured" with sellIn 0 and quality 20
    When I update the quality
    Then The item should have sellIn -1 and quality 16

  Scenario: Conjured item after sell date
    Given An item named "Conjured" with sellIn -1 and quality 20
    When I update the quality
    Then The item should have sellIn -2 and quality 16

  Scenario: Conjured item quality never negative
    Given An item named "Conjured" with sellIn 5 and quality 1
    When I update the quality
    Then The item should have sellIn 4 and quality 0