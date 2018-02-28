Simple Project Which have example of byte serialization
results compared with of Java Microbenchmark Harness (JMH)


CPU: Intel® Core™ i7-7700 CPU @ 3.60GHz × 8 
RAM: 23.4 GiB

Result of JMH Test:

# Run complete. Total time: 00:32:17

Benchmark                                                  Mode  Samples      Score  Score error  Units
c.s.b.t.Main.testSerializationHomeBrewSerializer           avgt      200  24140.829      396.312  ns/op
c.s.b.t.Main.testSerializationHomeBrewSerializerFlatObj    avgt      200  18093.539      147.856  ns/op
c.s.b.t.Main.testSerializationKryoSerializer               avgt      200  15521.696      176.788  ns/op
c.s.b.t.Main.testSerializationKryoSerializerFlatObj        avgt      200  11652.337      130.939  ns/op
