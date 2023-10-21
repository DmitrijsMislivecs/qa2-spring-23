Feature: Weather forecast

  Scenario: Full weather info checks
    Given city id is 12345

    When we are requesting weather forecast

    Then latitude is 39.31
    And longitude is -74.5
    And timezone is "America/New_York"
    And timezone offset is -18000

    And current weather data is:
      | dt         | 1646318698 |
      | sunrise    | 1646306882 |
      | sunset     | 1646347929 |
      | temp       | 282.21     |
      | feel_like  | 278.41     |
      | pressure   | 1014       |
      | humidity   | 65         |
      | dew_point  | 275.99     |
      | uvi        | 2.55       |
      | clouds     | 40         |
      | visibility | 10000      |
      | wind_speed | 8.75       |
      | wind_deg   | 360        |
      | wind_gust  | 13.89      |

    And current weather details are:
      | id          | 802             |
      | main        | Clouds          |
      | description | scatteredclouds |
      | icon        | 03d             |

    And minutely weather data are:
      | dt            | 1646318700 |
      | precipitation | 0          |

    And hourly weather data are:
      | dt         | 1646316000 |
      | temp       | 281.94     |
      | feels_like | 278.49     |
      | pressure   | 1014       |
      | humidity   | 67         |
      | dew_point  | 276.16     |
      | uvi        | 1.49       |
      | clouds     | 52         |
      | visibility | 10000      |
      | wind_speed | 7.16       |
      | wind_deg   | 313        |
      | wind_gust  | 10.71      |

    And hourly weather details are:
      | id          | 803          |
      | main        | Clouds       |
      | description | brokenclouds |
      | icon        | 04d          |

    And hourly pop is 0.03

    And daily weather data are:
      | dt         | 1646326800 |
      | sunrise    | 1646306882 |
      | sunset     | 1646347929 |
      | moonrise   | 1646309880 |
      | moonset    | 1646352120 |
      | moon_phase | 0.03       |

    And daily temp weather details is:
      | day   | 281.63 |
      | min   | 271.72 |
      | max   | 282.21 |
      | night | 271.72 |
      | eve   | 277.99 |
      | morn  | 280.92 |

    And daily feels_like details is:
      | day   | 277.83 |
      | night | 264.72 |
      | eve   | 273.35 |
      | morn  | 277.66 |

    And daily pressure is 1016
    And daily humidity is 55
    And daily dew_point is 273.12
    And daily wind_speed is 9.29
    And daily wind_deg is 3
    And daily wind_gust is 16.48

    And daily weather details are:
      | id          | 500       |
      | main        | Rain      |
      | description | lightrain |
      | icon        | 10d       |

    And daily clouds is 49
    And daily pop is 0.25
    And daily rain is 0.11
    And daily uvi is 3.38

    And alerts weather data are:
      | sender_name | NWSPhiladelphia-MountHolly(NewJersey,Delaware,SoutheasternPennsylvania)                                                                                                                                                                                                                                                                                                                                                               |
      | event       | SmallCraftAdvisory                                                                                                                                                                                                                                                                                                                                                                                                                    |
      | start       | 1646344800                                                                                                                                                                                                                                                                                                                                                                                                                            |
      | end         | 1646380800                                                                                                                                                                                                                                                                                                                                                                                                                            |
      | description | ...SMALLCRAFTADVISORYREMAINSINEFFECTFROM5PMTHIS\nAFTERNOONTO3AMESTFRIDAY...\n*WHAT...Northwinds15to20ktwithgustsupto25ktandseas\n3to5ftexpected.\n*WHERE...CoastalwatersfromLittleEggInlettoGreatEgg\nInletNJout20nm,CoastalwatersfromGreatEggInletto\nCapeMayNJout20nmandCoastalwatersfromManasquanInlet\ntoLittleEggInletNJout20nm.\n*WHEN...From5PMthisafternoonto3AMESTFriday.\n*IMPACTS...Conditionswillbehazardoustosmallcraft. |

    And alerts tags details list is blank
    