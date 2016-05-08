[Index](index.md)

### A library for generating Finite State Transducers based on Levenshtein Automata.

Levenshtein transducers accept a query term and return all terms in a
dictionary that are within n spelling errors away from it. They constitute a
highly-efficient (space _and_ time) class of spelling correctors that work very
well when you do not require context while making suggestions.  Forget about
performing a linear scan over your dictionary to find all terms that are
sufficiently-close to the user's query, using a quadratic implementation of the
[Levenshtein distance][wikipedia-levenshtein-distance] or
[Damerau-Levenshtein distance][wikipedia-damerau-levenshtein-distance], these
babies find _all_ the terms from your dictionary in linear time _on the length
of the query term_ (not on the size of the dictionary, on the length of the
query term).

If you need context, then take the candidates generated by the transducer as a
starting place, and plug them into whatever model you're using for context (such
as by selecting the sequence of terms that have the greatest probability of
appearing together).

For a quick demonstration, please visit the [Github Page, here][live-demo].
There's also a command-line interface, [liblevenshtein-java-cli][java-cli].
Please see its [README.md][java-cli-readme] for acquisition and usage information.

[Installation](installation.md)
----------------------------

Below, you will find instructions for how to clone
[universal-automata/liblevenshtein-java][github-repo] and checkout its
submodules, which include the source code for all supported languages:

#### Installation

##### Maven

```xml
<dependency>
  <groupId>com.github.universal-automata</groupId>
  <artifactId>liblevenshtein</artifactId>
  <version>3.0.0-alpha.2</version>
</dependency>
```

##### Apache Buildr

```ruby
'com.github.universal-automata:liblevenshtein:jar:3.0.0-alpha.2'
```

##### Apache Ivy

```xml
<dependency org="com.github.universal-automata" name="liblevenshtein" rev="3.0.0-alpha.2" />
```

##### Groovy Grape

```groovy
@Grapes(
@Grab(group='com.github.universal-automata', module='liblevenshtein', version='3.0.0-alpha.2')
)
```

##### Gradle / Grails

```groovy
compile 'com.github.universal-automata:liblevenshtein:3.0.0-alpha.2'
```

##### Scala SBT

```scala
libraryDependencies += "com.github.universal-automata" % "liblevenshtein" % "3.0.0-alpha.2"
```

##### Leiningen

```clojure
[com.github.universal-automata/liblevenshtein "3.0.0-alpha.2"]
```

##### Git

```
% git clone --progress git@github.com:universal-automata/liblevenshtein-java.git
Cloning into 'liblevenshtein-java'...
remote: Counting objects: 5490, done.        
remote: Compressing objects: 100% (2014/2014), done.        
remote: Total 5490 (delta 1485), reused 0 (delta 0), pack-reused 3317        
Receiving objects: 100% (5490/5490), 3.51 MiB | 2.00 MiB/s, done.
Resolving deltas: 100% (3100/3100), done.
Checking connectivity... done.

% cd liblevenshtein-java
% git pull --progress
Already up-to-date.

% git fetch --progress --tags
% git checkout --progress master
Already on 'master'
Your branch is up-to-date with 'origin/master'.

% git submodule init
% git submodule update

```

Please see [Installation](installation.md) for more details.

[Building](building.md)
--------------------

```
% gradle jar
[buildinfo] Not using buildInfo properties file for this build.
:extractIncludeProto
:extractProto
:generateProto
:compileJavawarning: No processor claimed any of these annotations: lombok.Setter,lombok.Getter,lombok.experimental.ExtensionMethod,lombok.NonNull,lombok.RequiredArgsConstructor,lombok.EqualsAndHashCode,lombok.Value,lombok.extern.slf4j.Slf4j,lombok.Builder,lombok.ToString,lombok.Data,lombok.AllArgsConstructor,lombok.NoArgsConstructor
1 warning

:processResources
:classes
:jar

BUILD SUCCESSFUL

Total time: 6.652 secs

This build could be faster, please consider using the Gradle Daemon: https://docs.gradle.org/2.13/userguide/gradle_daemon.html


```

Please see [Building](building.md) for more details.

[Testing](testing.md)
------------------

```
% gradle clean check
[buildinfo] Not using buildInfo properties file for this build.
:clean
:extractIncludeProto
:extractProto UP-TO-DATE
:generateProto
:compileJavawarning: No processor claimed any of these annotations: lombok.Setter,lombok.Getter,lombok.experimental.ExtensionMethod,lombok.NonNull,lombok.RequiredArgsConstructor,lombok.EqualsAndHashCode,lombok.Value,lombok.extern.slf4j.Slf4j,lombok.Builder,lombok.ToString,lombok.Data,lombok.AllArgsConstructor,lombok.NoArgsConstructor
1 warning

:processResources
:classes
:checkstyleMain[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/LazyTransducerCollection.java:233:20: 'term' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/LazyTransducerCollection.java:234:17: 'k' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/LazyTransducerCollection.java:235:17: 'i' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/State.java:34:36: 'head' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/State.java:136:7: Parameter lhsHead should be final. [FinalParameters]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/State.java:137:7: Parameter rhsHead should be final. [FinalParameters]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/State.java:170:42: 'head' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/factory/TransducerBuilder.java:102:41: 'dictionary' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/factory/TransducerBuilder.java:103:21: 'isSorted' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/factory/TransducerBuilder.java:124:16: 'dictionary' hides a field. [HiddenField]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/main/java/com/github/liblevenshtein/transducer/factory/TransducerBuilder.java:241:57: 'algorithm' hides a field. [HiddenField]

:extractIncludeTaskProto
:extractTaskProto
:generateTaskProto UP-TO-DATE
:compileTaskJavawarning: No processor claimed any of these annotations: lombok.extern.slf4j.Slf4j,lombok.Getter,lombok.SneakyThrows,edu.umd.cs.findbugs.annotations.SuppressFBWarnings
1 warning

:processTaskResources
:taskClasses
:checkstyleTask[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/task/java/com/github/liblevenshtein/task/Action.java:448:25: 'cli' hides a field. [HiddenField]

:extractIncludeTestProto
:extractTestProto UP-TO-DATE
:generateTestProto UP-TO-DATE
:compileTestJavawarning: No processor claimed any of these annotations: org.testng.annotations.BeforeTest,lombok.extern.slf4j.Slf4j,org.testng.annotations.DataProvider,lombok.Getter,org.testng.annotations.BeforeClass,lombok.RequiredArgsConstructor,org.testng.annotations.BeforeMethod,org.testng.annotations.Test
1 warning

:processTestResources
:testClasses
:checkstyleTest[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/test/java/com/github/liblevenshtein/transducer/StateTransitionFunctionTest.java:199: Comment matches to-do format '\b(TODO|FIXME)\b'. [TodoComment]
[ant:checkstyle] [WARN] /tmp/GenerateWikidoc-5624217346198740513/liblevenshtein-java/src/test/java/com/github/liblevenshtein/transducer/StateTransitionFunctionTest.java:236: Comment matches to-do format '\b(TODO|FIXME)\b'. [TodoComment]

:findbugsMain
:findbugsTask
:findbugsTest
:jdependMain
:jdependTask
:jdependTest
[ant:jdependreport] 
# ... TRUNCATED ...


```

Please see [Testing](testing.md) for more details.

[Usage](usage.md)
--------------

Let's say you have the following content in a plain text file called,
[top-20-most-common-english-words.txt][top-20-most-common-english-words.txt]
(note that the file has one term per line):

```
the
be
to
of
and
a
in
that
have
I
it
for
not
on
with
he
as
you
do
at
```

The following provides you a way to query its content:

```java
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.liblevenshtein.collection.dictionary.SortedDawg;
import com.github.liblevenshtein.Algorithm;
import com.github.liblevenshtein.Candidate;
import com.github.liblevenshtein.ITransducer;
import com.github.liblevenshtein.factory.TransducerBuilder;
import com.github.liblevenshtein.serialization.PlainTextSerializer;
import com.github.liblevenshtein.serialization.ProtobufSerializer;
import com.github.liblevenshtein.serialization.Serializer;

// ...

final SortedDawg dictionary;
final Path dictionaryPath =
  Paths.get("/path/to/top-20-most-common-english-words.txt");
try (final InputStream stream = Files.newInputStream(dictionaryPath)) {
  // The PlainTextSerializer constructor accepts an optional boolean specifying
  // whether the dictionary is already sorted lexicographically, in ascending
  // order.  If it is sorted, then passing true will optimize the construction
  // of the dictionary; you may pass false whether the dictionary is sorted or
  // not (this is the default and safest behavior if you don't know whether the
  // dictionary is sorted).
  final Serializer serializer = new PlainTextSerializer(false);
  dictionary = serializer.deserialize(SortedDawg.class, stream);
}

final ITransducer<Candidate> transducer = new TransducerBuilder()
  .dictionary(dictionary)
  .algorithm(Algorithm.TRANSPOSITION)
  .defaultMaxDistance(2)
  .includeDistance(true)
  .build();

for (final String queryTerm : new String[] {"foo", "bar"}) {
  System.out.println(
    "+-------------------------------------------------------------------------------");
  System.out.printf("| Spelling Candidates for Query Term: \"%s\"%n", queryTerm);
  System.out.println(
    "+-------------------------------------------------------------------------------");
  for (final Candidate candidate : transducer.transduce(queryTerm)) {
    System.out.printf("| d(\"%s\", \"%s\") = [%d]%n",
      queryTerm,
      candidate.term(),
      candidate.distance());
  }
}

// +-------------------------------------------------------------------------------
// | Spelling Candidates for Query Term: "foo"
// +-------------------------------------------------------------------------------
// | d("foo", "do") = [2]
// | d("foo", "of") = [2]
// | d("foo", "on") = [2]
// | d("foo", "to") = [2]
// | d("foo", "for") = [1]
// | d("foo", "not") = [2]
// | d("foo", "you") = [2]
// +-------------------------------------------------------------------------------
// | Spelling Candidates for Query Term: "bar"
// +-------------------------------------------------------------------------------
// | d("bar", "a") = [2]
// | d("bar", "as") = [2]
// | d("bar", "at") = [2]
// | d("bar", "be") = [2]
// | d("bar", "for") = [2]

// ...
```

If you want to serialize your dictionary to a format that's easy to read later,
do the following:

```java
final Path serializedDictionaryPath =
  Paths.get("/path/to/top-20-most-common-english-words.protobuf.bytes");
try (final OutputStream stream = Files.newOutputStream(serializedDictionaryPath)) {
  final Serializer serializer = new ProtobufSerializer();
  serializer.serialize(dictionary, stream);
}
```

Then, you can read the dictionary later, in much the same way you read the plain
text version:

```java
final SortedDawg deserializedDictionary;
try (final InputStream stream = Files.newInputStream(serializedDictionaryPath)) {
  final Serializer serializer = new ProtobufSerializer();
  deserializedDictionary = serializer.deserialize(SortedDawg.class, stream);
}
```

Serialization is not restricted to dictionaries, you may also (de)serialize
transducers.

Please see [Usage](usage.md) for more details.

History
------------------

Based largely on the works of [Stoyan Mihov][stoyan-mihov],
[Klaus Schulz][klaus-schulz], and Petar Nikolaev Mitankin, this
library generates Levenshtein transducers using nothing more than an input list
of dictionary terms. The referenced literature includes:
"[Fast String Correction with Levenshtein-Automata][fast-string-correction-2002]",
which defines the algorithm used to generate the Levenshtein automata,
"[Universal Levenshtein Automata. Building and Properties][universal-automata-2005]",
which provided many mathematical proofs that helped me understand the algorithm
and supplied the recursive definitions upon which I based my distance functions,
and
"[Incremental Construction of Minimal Acyclic Finite-State Automata][incremental-construction-dawg-2000]",
that defined an algorithm for constructing Minimal Acyclic Finite-State
Automata in linear time (i.e. MA-FSA, also known as DAWGs: Directed Acyclic Word
Graphs) which I use to store the dictionary of terms.

Upon construction, the list of dictionary terms is indexed as an MA-FSA and a
transducer is initialized according to the maximum edit distance and algorithm
provided. When queried against, the states of the Levenshtein automaton
corresponding to the query term, maximum edit distance, and algorithm specified
are constructed on-demand (lazily) as the automaton is evaluated, as described
by the paper,
"[Fast String Correction with Levenshtein-Automata][fast-string-correction-2002]".
The Levenshtein automaton is intersected with the dictionary MA-FSA, and every
string accepted by both automata is emitted in a list of correction candidates
for the query term.

In contrast to many other Levenshtein automata-based algorithms, the entire
Levenshtein automaton needn't be constructed prior to evaluation, and only those
states of the automaton which are actually required are derived, as needed,
thereby greatly improving the efficiency of the transducer in terms of both
space and time complexity.

The infamous blog post,
"[Damn Cool Algorithms: Levenshtein Automata][damn-cool-algos-levenshtein-automata-2010]",
provided me with a good starting point for this transducer, but the algorithm
proposed therein was too inefficient for my needs.  Yet, it did reference the
paper
"[Fast String Correction with Levenshtein-Automata][fast-string-correction-2002]",
which I ultimately used as the basis of the Levenshtein automata.  The same
paper also serves as the basis of the Levenshtein automata used by the Apache
projects, Lucene and Solr ([Lucene's FuzzyQuery is 100 times faster in 4.0][lucene-fuzzy-2011]),
which itself is based on the project by Jean-Philippe Barrette-LaPierre, [Moman][moman].

Steve Hanov pointed me to the paper,
"[Incremental Construction of Minimal Acyclic Finite-State Automata][incremental-construction-dawg-2000]",
in his blog post entitled,
"[Compressing dictionaries with a DAWG][dict-compress-dawg-2011]".  Another of
Steve's blogs also made an impact on me, namely
"[Fast and Easy Levenshtein distance using a Trie][fast-easy-correct-trie-2011]".

I've become heavily involved with the online movement regarding MOOCs (Massive
Open Online Classrooms), and the following courses taught me much regarding the
material within this library:

1. [Automata][coursera-automata]
2. [Compilers][coursera-compilers]
3. [Natural Language Processing][coursera-nlp]

Finally, I must credit the course which first introduced me to the field of
Information Retrieval, "Mathematical Applications in Search Engine Design",
taught by [Dr. Rao Li][rao-li] at the
[University of South Carolina Aiken][usca]. I highly recommend
that course if you are in the area.

[liblevenshtein-java][github-repo] is maintained by[@dylon][github-author] ([dylon.devo+liblevenshtein-java@gmail.com][github-email])

[coursera-automata]: https://class.coursera.org/automata "Jeffrey Ullman (Coursera)"
[coursera-compilers]: https://class.coursera.org/compilers "Alex Aiken (Coursera)"
[coursera-nlp]: https://class.coursera.org/nlp "Dan Jurafsky and Chris Manning (Coursera)"
[damn-cool-algos-levenshtein-automata-2010]: http://blog.notdot.net/2010/07/Damn-Cool-Algorithms-Levenshtein-Automata "Nick Johnson (2010)"
[dict-compress-dawg-2011]: http://stevehanov.ca/blog/index.php?id=115 "Steve Hanov (2011)"
[fast-easy-correct-trie-2011]: http://stevehanov.ca/blog/index.php?id=114 "Steve Hanov (2011)"
[fast-string-correction-2002]: http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.16.652 "Klaus Schulz and Stoyan Mihov (2002)"
[incremental-construction-dawg-2000]: http://dl.acm.org/citation.cfm?id=971842 "Jan Daciuk, Bruce W. Watson, Stoyan Mihov, and Richard E. Watson (2000)"
[klaus-schulz]: http://www.cis.uni-muenchen.de/people/schulz.html "Klaus Schulz"
[lucene-fuzzy-2011]: http://blog.mikemccandless.com/2011/03/lucenes-fuzzyquery-is-100-times-faster.html "Michael McCandless (2011)"
[moman]: https://sites.google.com/site/rrettesite/moman "Moman"
[rao-li]: http://www.usca.edu/math/~mathdept/rli/ "Dr. Rao Li"
[stoyan-mihov]: http://www.lml.bas.bg/~stoyan/ "Stoyan Mihov"
[universal-automata-2005]: http://www.fmi.uni-sofia.bg/fmi/logic/theses/mitankin-en.pdf "Petar Nikolaev Mitankin (2005)"
[usca]: http://web.usca.edu/ "University of South Carolina Aiken"

[live-demo]: http://universal-automata.github.io/liblevenshtein/

[github-author]: https://github.com/dylon "Dylon Edwards <dylon.devo+liblevenshtein-java@gmail.com>"
[github-demo]: http://universal-automata.github.io/liblevenshtein/ "liblevenshtein demo"
[github-email]: mailto:dylon.devo+liblevenshtein-java@gmail.com "Dylon Edwards <dylon.devo+liblevenshtein-java@gmail.com>"
[github-repo]: https://github.com/universal-automata/liblevenshtein-java/ "universal-automata/liblevenshtein-java"

[wikipedia-damerau-levenshtein-distance]: https://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance "Damerau–Levenshtein distance"
[wikipedia-levenshtein-distance]: https://en.wikipedia.org/wiki/Levenshtein_distance "Levenshtein distance"

[master-branch]: https://github.com/universal-automata/liblevenshtein-java/tree/master
[release-branch]: https://github.com/universal-automata/liblevenshtein-java/tree/release
[release-branch-2.x]: https://github.com/universal-automata/liblevenshtein-java/tree/release-2.x

[wiki]: https://github.com/universal-automata/liblevenshtein-java/blob/gh-pages/docs/wiki/3.0.0-alpha.2/index.md "liblevenshtein 3.0.0-alpha.2 Wiki"
[javadoc]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/index.html "liblevenshtein 3.0.0-alpha.2 API"
[tagged-source]: https://github.com/universal-automata/liblevenshtein-java/tree/3.0.0-alpha.2/src "liblevenshtein 3.0.0-alpha.2"

[java-lib]: https://github.com/universal-automata/liblevenshtein-java "liblevenshtein-java"
[java-cli]: https://github.com/universal-automata/liblevenshtein-java-cli "liblevenshtein-java-cli"
[java-cli-readme]: https://github.com/universal-automata/liblevenshtein-java-cli/blob/master/README.md "liblevenshtein-java-cli, README.md"

[javadoc/Iterable]: https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html?is-external=true "java.lang.Iterable"
[javadoc/Iterator.next()]: https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html#next-- "java.util.Iterator.next()"
[javadoc/Iterator]: https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html "java.util.Iterator"
[javadoc/String]: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html "java.lang.String"

[javadoc/Algorithm.MERGE_AND_SPLIT]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/Algorithm.html#MERGE_AND_SPLIT "Algorithm.MERGE_AND_SPLIT"
[javadoc/Algorithm.STANDARD]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/Algorithm.html#STANDARD "Algorithm.STANDARD"
[javadoc/Algorithm.TRANSPOSITION]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/Algorithm.html#TRANSPOSITION "Algorithm.TRANSPOSITION"
[javadoc/ITransducer.transduce(String)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/ITransducer.html#transduce-java.lang.String- "ITransducer.transduce(String):Iterable"
[javadoc/ITransducer.transduce(String,int)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/ITransducer.html#transduce-java.lang.String-int- "ITransducer.transduce(String,int):Iterable"
[javadoc/MemoizedMergeAndSplit.between(String,String)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/distance/MemoizedMergeAndSplit.html "MemoizedMergeAndSplit.between(String,String):int"
[javadoc/MemoizedStandard.between(String,String)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/distance/MemoizedStandard.html "MemoizedStandard.between(String,String):int"
[javadoc/MemoizedTransposition.between(String,String)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/distance/MemoizedTransposition.html "MemoizedTransposition.between(String,String):int"
[javadoc/TransducerBuilder.algorithm(Algorithm)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/factory/TransducerBuilder.html#algorithm-com.github.liblevenshtein.Algorithm- "TransducerBuilder.algorithm(Algorithm):TransducerBuilder"
[javadoc/TransducerBuilder.build()]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/factory/TransducerBuilder.html#build-- "TransducerBuilder.build():ITransducer"
[javadoc/TransducerBuilder.defaultMaxDistance(int)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/factory/TransducerBuilder.html#defaultMaxDistance-int- "TransducerBuilder.defaultMaxDistance(int):TransducerBuilder"
[javadoc/TransducerBuilder.dictionary(Collection)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/factory/TransducerBuilder.html#dictionary-java.util.Collection- "TransducerBuilder.dictionary(Collection):TransducerBuilder"
[javadoc/TransducerBuilder.dictionary(Collection,boolean)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/factory/TransducerBuilder.html#dictionary-java.util.Collection-boolean- "TransducerBuilder.dictionary(Collection,boolean):TransducerBuilder"
[javadoc/TransducerBuilder.includeDistance(boolean)]: http://universal-automata.github.io/liblevenshtein-java/docs/javadoc/3.0.0-alpha.2/com/github/liblevenshtein/transducer/factory/TransducerBuilder.html#includeDistance-boolean- "TransducerBuilder.includeDistance(boolean):TransducerBuilder"

[src/Candidate]: https://github.com/universal-automata/liblevenshtein-java/blob/master/src/main/java/com/github/liblevenshtein/transducer/Candidate.java "Candidate.java"
[src/ITransducer]: https://github.com/universal-automata/liblevenshtein-java/blob/3.0.0-alpha.2/src/main/java/com/github/liblevenshtein/transducer/factory/TransducerBuilder.java "TransducerBuilder.java"
[src/TransducerBuilder.java]: https://github.com/universal-automata/liblevenshtein-java/blob/3.0.0-alpha.2/src/main/java/com/github/liblevenshtein/transducer/factory/TransducerBuilder.java "TransducerBuilder.java"
[src/build.gradle]: https://github.com/universal-automata/liblevenshtein-java/blob/3.0.0-alpha.2/build.gradle "build.gradle"

[top-20-most-common-english-words.txt]: https://raw.githubusercontent.com/universal-automata/liblevenshtein-java/3.0.0-alpha.2/src/test/resources/top-20-most-common-english-words.txt "top-20-most-common-english-words.txt"