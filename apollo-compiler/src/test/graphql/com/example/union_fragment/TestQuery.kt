// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.union_fragment

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.union_fragment.adapter.TestQuery_ResponseAdapter
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

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
    val search: List<Search?>?
  ) : Operation.Data {
    fun searchFilterNotNull(): List<Search>? = search?.filterNotNull()

    interface Search {
      val __typename: String

      interface Starship : Search, com.example.union_fragment.fragment.Starship {
        override val __typename: String

        /**
         * The ID of the starship
         */
        val id: String

        /**
         * The name of the starship
         */
        override val name: String
      }

      data class StarshipSearch(
        override val __typename: String,
        /**
         * The ID of the starship
         */
        override val id: String,
        /**
         * The name of the starship
         */
        override val name: String
      ) : Search, Starship, com.example.union_fragment.fragment.Starship

      data class OtherSearch(
        override val __typename: String
      ) : Search

      companion object {
        fun Search.asStarship(): Starship? = this as? Starship

        fun Search.starship(): com.example.union_fragment.fragment.Starship? = this as?
            com.example.union_fragment.fragment.Starship
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "30d1eb05153f684ad9f80a0483579f001b507c53f8971d475f6c8d3690622ef4"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  search(text: "test") {
          |    __typename
          |    ... on Starship {
          |      id
          |    }
          |    ...Starship
          |  }
          |}
          |fragment Starship on Starship {
          |  __typename
          |  name
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "TestQuery"
  }
}
