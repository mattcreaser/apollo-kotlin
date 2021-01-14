// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.hero_details

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.hero_details.adapter.HeroDetails_ResponseAdapter
import com.example.hero_details.type.Hero_type
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class HeroDetails : Query<HeroDetails.Data> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): String = OPERATION_NAME

  override fun adapter(): ResponseAdapter<Data> = HeroDetails_ResponseAdapter
  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    /**
     * A character from the Star Wars universe
     */
    data class Hero(
      /**
       * Hero type
       */
      val type: Hero_type,
      /**
       * The name of the character
       */
      val name: String,
      /**
       * The friends of the character exposed as a connection with edges
       */
      val friendsConnection: FriendsConnection
    ) {
      /**
       * A connection object for a character's friends
       */
      data class FriendsConnection(
        /**
         * The total number of friends
         */
        val totalCount: Int?,
        /**
         * The edges for each of the character's friends.
         */
        val edges: List<Edge?>?
      ) {
        fun edgesFilterNotNull(): List<Edge>? = edges?.filterNotNull()

        /**
         * An edge object for a character's friends
         */
        data class Edge(
          /**
           * The character represented by this friendship edge
           */
          val node: Node?
        ) {
          /**
           * A character from the Star Wars universe
           */
          data class Node(
            /**
             * The name of the character
             */
            val name: String
          )
        }
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "8f6f2c3852a89d45ea7eaa08a249906a1fb8f1733c4f2326d0fb8fb75c4af1e3"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query HeroDetails {
          |  hero {
          |    type
          |    name
          |    friendsConnection {
          |      totalCount
          |      edges {
          |        node {
          |          name
          |        }
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "HeroDetails"
  }
}
