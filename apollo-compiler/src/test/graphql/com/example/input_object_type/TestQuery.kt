// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.input_object_type

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.input_object_type.adapter.TestQuery_ResponseAdapter
import com.example.input_object_type.type.Episode
import com.example.input_object_type.type.ReviewInput
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
data class TestQuery(
  val ep: Episode,
  val review: ReviewInput
) : Mutation<TestQuery.Data> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["ep"] = this@TestQuery.ep
      this["review"] = this@TestQuery.review
    }

    override fun marshaller(): InputFieldMarshaller {
      return InputFieldMarshaller.invoke { writer ->
        writer.writeString("ep", this@TestQuery.ep.rawValue)
        writer.writeObject("review", this@TestQuery.review.marshaller())
      }
    }
  }

  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = variables

  override fun name(): String = OPERATION_NAME

  override fun adapter(): ResponseAdapter<Data> = TestQuery_ResponseAdapter
  /**
   * The mutation type, represents all updates we can make to our data
   */
  data class Data(
    val createReview: CreateReview?
  ) : Operation.Data {
    /**
     * Represents a review for a movie
     */
    data class CreateReview(
      /**
       * The number of stars this review gave, 1-5
       */
      val stars: Int,
      /**
       * Comment about the movie
       */
      val commentary: String?
    )
  }

  companion object {
    const val OPERATION_ID: String =
        "2a1de6af8435bb9169562d78714566aaf26a9741ef16b72f49955dc615237b09"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |mutation TestQuery(${'$'}ep: Episode!, ${'$'}review: ReviewInput!) {
          |  createReview(episode: ${'$'}ep, review: ${'$'}review) {
          |    stars
          |    commentary
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "TestQuery"
  }
}
