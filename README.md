# Rate Finder #

My solution to check what package the user will need after choose dimensions.
You can find the MainActivity.java [here](app/src/main/java/rate/finder/MainActivity.java).

| Package Type   | Length   | Breadth   | Height   | Cost   | 
|----------------|----------|-----------|----------|--------|
| Small          | 200mm    | 300mm     | 150mm    | $5.00  |
| Medium         | 300mm    | 400mm     | 200mm    | $7.50  |
| Large          | 400mm    | 600mm     | 250mm    | $8.50  |

## Features ##
The app when supplied the dimensions (maxLength x maxBreadth x height) and weight of a package, advise on the cost and type of package required. If the package exceeds these dimensions - or is over 25kg - then the service not return a packaging solution.
