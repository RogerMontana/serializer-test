Simple Project Which have example of byte serialization
results compared with Java Microbenchmark Harness (JMH)

CPU: Intel® Core™ i7-7700 CPU @ 3.60GHz × 8 
RAM: 23.4 GiB

Result of JMH Test:

|Benchmark       FlatObj              |Mode   |Samples  |Score      |Score error |Units |
| :----------------------------------:| :---: | :-----: |:--------: |:----------:|:----:|
|GsonToBytesSerializerFlatObj         |  avgt |      10 |  6984.254 |     494.971| ns/op|
|KryoSerializerFlatObj                |  avgt |      10 | 12334.007 |     636.009| ns/op|
|JavaSerializerFlatObj                |  avgt |      10 | 18744.443 |    1049.000| ns/op|
|ApacheSerializerFlatObj              |  avgt |      10 | 18963.227 |    1000.702| ns/op|


|Benchmark       Obj with inner Object|Mode   |Samples  |Score      |Score error |Units |
| :----------------------------------:| :---: | :-----: |:--------: |:----------:|:----:|
|GsonToBytesSerializerObj             |  avgt |      10 | 11945.070 |     586.754| ns/op|
|KryoSerializerObj                    |  avgt |      10 | 15624.360 |     367.077| ns/op|
|ApacheSerializerObj                  |  avgt |      10 | 23692.375 |    1798.404| ns/op|
|JavaSerializerObj                    |  avgt |      10 | 25044.740 |    2399.950| ns/op|
