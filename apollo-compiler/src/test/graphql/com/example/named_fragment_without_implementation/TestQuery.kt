// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_without_implementation

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.named_fragment_without_implementation.adapter.TestQuery_ResponseAdapter
import com.example.named_fragment_without_implementation.fragment.DroidDetails
import com.example.named_fragment_without_implementation.fragment.HumanDetails
import kotlin.Double
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery : Query<TestQuery.Data> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): String = OPERATION_NAME

  override fun adapter(): ResponseAdapter<Data> = TestQuery_ResponseAdapter
  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    /**
     * A character from the Star Wars universe
     */
    interface Hero {
      val __typename: String

      /**
       * The name of the character
       */
      val name: String

      interface Human : Hero, HumanDetails {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * Height in the preferred unit, default is meters
         */
        override val height: Double?
      }

      interface Droid : Hero, DroidDetails {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * This droid's primary function
         */
        override val primaryFunction: String?
      }

      data class HumanHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * Height in the preferred unit, default is meters
         */
        override val height: Double?
      ) : Hero, Human, HumanDetails

      data class DroidHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * This droid's primary function
         */
        override val primaryFunction: String?
      ) : Hero, Droid, DroidDetails

      data class OtherHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String
      ) : Hero

      companion object {
        fun Hero.asHuman(): Human? = this as? Human

        fun Hero.humanDetails(): HumanDetails? = this as? HumanDetails

        fun Hero.asDroid(): Droid? = this as? Droid

        fun Hero.droidDetails(): DroidDetails? = this as? DroidDetails
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "3081feaebd920cae2f043ab275040816dd7b5ad96f81512c93dc843a9e4e918c"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  hero {
          |    __typename
          |    name
          |    ...HumanDetails
          |    ...DroidDetails
          |  }
          |}
          |fragment HumanDetails on Human {
          |  __typename
          |  height
          |}
          |fragment DroidDetails on Droid {
          |  __typename
          |  primaryFunction
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "TestQuery"
  }
}
