package org.apache.flink.training.exercises.common.sources;

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


import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.flink.training.exercises.common.datatypes.Comment;

import java.io.*;
import java.util.Scanner;

/**
 * This SourceFunction generates a data stream of TaxiFare records that include event time
 * timestamps.
 *
 * <p>The stream is generated in order, and it includes Watermarks.
 *
 */
public class CommentGenerator implements SourceFunction<Comment> {

    private volatile boolean running = true;

    @Override
    public void run(SourceContext<Comment> ctx) throws Exception {
        Scanner sc = new Scanner(new File("comments_train.csv"));
        sc.useDelimiter("\r\n");   //sets the delimiter pattern
        sc.next();

        while (running) {
            String comment_csv = sc.next();
            String[] split_comment = comment_csv.split(",");
            Comment comment = new Comment(split_comment[1],Boolean.parseBoolean(split_comment[7]));
            ctx.collectWithTimestamp(comment, comment.getEventTime());
            ctx.emitWatermark(new Watermark(comment.getEventTime()));

            // match our event production rate to that of the TaxiRideGenerator
            Thread.sleep(100);
        }
    }

    @Override
    public void cancel() {
        running = false;
    }
}