# Rate Finder #

This is a solution to check what would be correct parcel size (small, medium or large) that the user would need to package his items.
You can find the MainActivity.java [here](app/src/main/java/rate/finder/MainActivity.java).

The parcel sizes available are given in the table below.

| Package Type   | Length   | Breadth   | Height   | Cost   | 
|----------------|----------|-----------|----------|--------|
| Small          | 200mm    | 300mm     | 150mm    | $5.00  |
| Medium         | 300mm    | 400mm     | 200mm    | $7.50  |
| Large          | 400mm    | 600mm     | 250mm    | $8.50  |

## Features ##

The app advises the cost and the type of parcel necessary to fit the dimension of the content selected by the users.
If the package exceeds these dimensions or it is over 25kg, then the service advised the user that there is no packaging solution available.
