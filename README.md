# Weather Information from Pincode using OpenWeather API

## Overview

This project demonstrates an algorithm that fetches weather information based on a pincode. It utilizes the OpenWeather API for geocoding to get latitude and longitude and then retrieves historical weather data for a specific date.

## Features

1. **Geocoding API**:
   - The algorithm uses OpenWeather's Geo Encoding API to convert the pincode into latitude and longitude values.

2. **Historical Weather Data**:
   - After obtaining the coordinates, it fetches weather data for a specific date using OpenWeather's Historical Weather API.
   - The date is converted into Unix time and passed into the API.

3. **Unix Time Conversion**:
   - The provided date is converted to Unix time (seconds since 1970-01-01 UTC) to be compatible with the OpenWeather Historical API requirements.

4. **Exception Handling**:
   - Proper error handling is implemented to manage invalid inputs, API failures, or unexpected responses.

5. **Input Validation**:
   - Validation mechanisms are in place to ensure the pincode is correct and the date is in the correct format before making API calls.

## Prerequisites

- Java (or any other language you're using)
- Maven or Gradle (for dependency management)
- OpenWeather API key (You can get one from [OpenWeather](https://openweathermap.org/api))

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/Abhijeet103/WeatherFromPincode/
   cd demo

## Limitation  
- with the current API i can only fetch data upto one year only , Exception when date is out of range is handled 
