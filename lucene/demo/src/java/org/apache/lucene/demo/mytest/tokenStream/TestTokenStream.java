package org.apache.lucene.demo.mytest.tokenStream;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.StringReader;

/**
 * 描述:
 * testTokenStream
 *
 * @Author HeFeng
 * @Create 2018-10-10 14:49
 */
public class TestTokenStream {

    public static void main(String[] args) throws Exception {
        Analyzer analyzer = new WhitespaceAnalyzer();
        String inputText = "This is a test text for token!";
        TokenStream tokenStream = analyzer.tokenStream("text", new StringReader(inputText));
//保存token字符串
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
//在调用incrementToken()开始消费token之前需要重置stream到一个干净的状态
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
//打印分词结果
            System.out.print("[" + charTermAttribute + "]");
        }
    }

}