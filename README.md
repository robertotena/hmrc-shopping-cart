# hmrc-shopping-cart
HMRC coding exercise


#### Assumptions

- Entry parameters: the service is accepting a list of `Item` objects instead of strings, as we would need a structure to map the string with the costs anyway. In the tests we create the Orange and Apple items, and if needed in further iterations we can add some queryable inventory in the main code.
- Cost data type: For simplicity `Float` has been chosen, but if we don't want to have any issues with floating point calculations, we should just use a `BigDecimal` or similar structure.