// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_fragment_with_nested_fragments

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.root_query_fragment_with_nested_fragments.adapter.TestQuery_ResponseAdapter
import com.example.root_query_fragment_with_nested_fragments.fragment.DroidFragment
import com.example.root_query_fragment_with_nested_fragments.fragment.HeroFragment
import com.example.root_query_fragment_with_nested_fragments.fragment.QueryFragment
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
  interface Data : Operation.Data {
    val __typename: String

    interface Query : Data, QueryFragment {
      override val __typename: String

      override val hero: Hero?

      override val droid: Droid?

      override val human: Human?

      /**
       * A character from the Star Wars universe
       */
      interface Hero : QueryFragment.Hero {
        override val __typename: String

        interface Character : Hero, HeroFragment, QueryFragment.Hero.Character, QueryFragment.Hero {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String
        }

        companion object {
          fun Hero.asCharacter(): Character? = this as? Character

          fun Hero.heroFragment(): HeroFragment? = this as? HeroFragment
        }
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      interface Droid : QueryFragment.Droid {
        override val __typename: String

        interface Droid : Query.Droid, DroidFragment, QueryFragment.Droid.Droid, QueryFragment.Droid
            {
          override val __typename: String

          /**
           * What others call this droid
           */
          override val name: String

          /**
           * This droid's primary function
           */
          override val primaryFunction: String?
        }

        companion object {
          fun Query.Droid.asDroid(): Droid? = this as? Droid

          fun Query.Droid.droidFragment(): DroidFragment? = this as? DroidFragment
        }
      }

      /**
       * A humanoid creature from the Star Wars universe
       */
      interface Human : QueryFragment.Human {
        override val __typename: String

        interface Human : Query.Human, QueryFragment.Human.Human, QueryFragment.Human {
          override val __typename: String

          /**
           * What this human calls themselves
           */
          override val name: String

          /**
           * The home planet of the human, or null if unknown
           */
          override val homePlanet: String?
        }

        companion object {
          fun Query.Human.asHuman(): Human? = this as? Human
        }
      }
    }

    data class QueryData(
      override val __typename: String,
      override val hero: Hero?,
      override val droid: Droid?,
      override val human: Human?
    ) : Data, Query, QueryFragment {
      /**
       * A character from the Star Wars universe
       */
      interface Hero : Query.Hero, QueryFragment.Hero {
        override val __typename: String

        data class CharacterHero(
          override val __typename: String,
          /**
           * The name of the character
           */
          override val name: String
        ) : Query.Hero, Query.Hero.Character, HeroFragment, QueryFragment.Hero.Character,
            QueryFragment.Hero, Hero

        data class OtherHero(
          override val __typename: String
        ) : Query.Hero, QueryFragment.Hero, Hero
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      interface Droid : Query.Droid, QueryFragment.Droid {
        override val __typename: String

        data class DroidDroid(
          override val __typename: String,
          /**
           * What others call this droid
           */
          override val name: String,
          /**
           * This droid's primary function
           */
          override val primaryFunction: String?
        ) : Query.Droid, Query.Droid.Droid, DroidFragment, QueryFragment.Droid.Droid,
            QueryFragment.Droid, Droid

        data class OtherDroid(
          override val __typename: String
        ) : Query.Droid, QueryFragment.Droid, Droid
      }

      /**
       * A humanoid creature from the Star Wars universe
       */
      interface Human : Query.Human, QueryFragment.Human {
        override val __typename: String

        data class HumanHuman(
          override val __typename: String,
          /**
           * What this human calls themselves
           */
          override val name: String,
          /**
           * The home planet of the human, or null if unknown
           */
          override val homePlanet: String?
        ) : Query.Human, Query.Human.Human, QueryFragment.Human.Human, QueryFragment.Human, Human

        data class OtherHuman(
          override val __typename: String
        ) : Query.Human, QueryFragment.Human, Human
      }
    }

    data class OtherData(
      override val __typename: String
    ) : Data

    companion object {
      fun Data.asQuery(): Query? = this as? Query

      fun Data.queryFragment(): QueryFragment? = this as? QueryFragment
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "a9a2dda27867aae4e7ec4ee3ed20374db9e0ac14f565cd293b397f8aa5580f1e"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  __typename
          |  ...QueryFragment
          |}
          |fragment QueryFragment on Query {
          |  __typename
          |  hero {
          |    __typename
          |    ...heroFragment
          |  }
          |  droid(id: 1) {
          |    __typename
          |    ...droidFragment
          |  }
          |  human(id: 1) {
          |    __typename
          |    ... on Human {
          |      name
          |      homePlanet
          |    }
          |  }
          |}
          |fragment heroFragment on Character {
          |  __typename
          |  name
          |}
          |fragment droidFragment on Droid {
          |  __typename
          |  name
          |  primaryFunction
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "TestQuery"
  }
}
