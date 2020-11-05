package org.apache.flink.training.exercises.common.datatypes;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Serializable;
import java.time.Instant;

/**
 * A TaxiFare has payment information about a taxi ride.
 *
 * <p>It has these fields in common with the TaxiRides
 * - the rideId
 * - the taxiId
 * - the driverId
 * - the startTime
 *
 * <p>It also includes
 * - the paymentType
 * - the tip
 * - the tolls
 * - the totalFare
 */
public class Comment implements Serializable {

    /**
     * Creates a TaxiFare with now as the start time.
     */
    public Comment() {
        this.startTime = Instant.now().toEpochMilli();
    }

    /**
     * Invents a TaxiFare.
     */
    public Comment(String body, boolean removed) {
        // DataGenerator g = new DataGenerator(rideId);

        this.body = body;
        this.removed = removed;
    }

    /**
     * Creates a TaxiFare with the given parameters.
     */
    /* public Comment(long rideId, long taxiId, long driverId, Instant startTime, String paymentType, float tip, float tolls, float totalFare) {
        this.rideId = rideId;
        this.taxiId = taxiId;
        this.driverId = driverId;
        this.startTime = startTime;
        this.paymentType = paymentType;
        this.tip = tip;
        this.tolls = tolls;
        this.totalFare = totalFare;
    }
     */

    public String body;
    public boolean removed;
    public long startTime;

    @Override
    public String toString() {

        return body + "," +
                removed + ",";
    }



     @Override
    public int hashCode() {
        return (int) this.startTime;
    }

    /**
     * Gets the fare's start time.
     */
    public long getEventTime() {
        return this.startTime;
    }

}

