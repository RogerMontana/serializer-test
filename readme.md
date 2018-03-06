Simple Project Which have example of byte serialization
results compared with Java Microbenchmark Harness (JMH)

CPU: Intel® Core™ i7-7700 CPU @ 3.60GHz × 8 
RAM: 23.4 GiB

Result of JMH Test:

Run complete. Total time: 01:04:33


|Benchmark                            |Mode   |Samples  |Score      |Score error |Units |
| :----------------------------------:| :---: | :-----: |:--------: |:----------:|:----:|
| ManualStringSerializerFlatObj       |  avgt |      200|  4965.42  |     19.073 | ns/op|
| ManualStringSerializerObj           |  avgt |      200|  7892.57  |     26.682 | ns/op|
| KryoSerializer                      |  avgt |      200| 16879.475 |     69.906 | ns/op|
| KryoSerializerFlatObj               |  avgt |      200| 12352.682 |     58.390 | ns/op|
| ApacheSerializer                    |  avgt |      200| 23671.631 |    112.764 | ns/op|
| ApacheSerializerFlatObj             |  avgt |      200| 17831.347 |     84.854 | ns/op|
| HomeBrewSerializer(Java)            |  avgt |      200| 24179.693 |    118.909 | ns/op|
| HomeBrewSerializerFlatObj (Java)    |  avgt |      200| 18252.110 |     82.053 | ns/op|


          