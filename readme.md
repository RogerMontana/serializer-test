Simple Project Which have example of byte serialization
results compared with of Java Microbenchmark Harness (JMH)


CPU: Intel® Core™ i7-7700 CPU @ 3.60GHz × 8 
RAM: 23.4 GiB

Result of JMH Test:

Run complete. Total time: 00:48:25

|Benchmark                                                 |Mode   |Samples  |Score      |Score error |Units |
| :------------------------------------------------------: | :---: | :-----: |:--------: |:----------:|:----:|
|c.s.b.t.Main.testSerializationApacheSerializer            |avgt   |  200    |24151.684  |    369.035 |ns/op |
|c.s.b.t.Main.testSerializationApacheSerializerFlatObj     |avgt   |  200    |17684.279  |    142.478 |ns/op |
|c.s.b.t.Main.testSerializationHomeBrewSerializer          |avgt   |  200    |22632.793  |    107.952 |ns/op |
|c.s.b.t.Main.testSerializationHomeBrewSerializerFlatObj   |avgt   |  200    |17335.996  |     79.378 |ns/op |
|c.s.b.t.Main.testSerializationKryoSerializer              |avgt   |  200    |14989.589  |     58.573 |ns/op |
|c.s.b.t.Main.testSerializationKryoSerializerFlatObj       |avgt   |  200    |10981.963  |    105.198 |ns/op |
