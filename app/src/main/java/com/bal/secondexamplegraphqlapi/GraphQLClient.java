package com.bal.secondexamplegraphqlapi;

import com.apollographql.apollo3.ApolloClient;

public class GraphQLClient {
    private  static ApolloClient apolloClient;

    private  GraphQLClient(){

    }
    public static  ApolloClient getApolloClientInstance(){
        if (apolloClient == null){
            apolloClient = new ApolloClient.Builder()
                    .serverUrl("https://rickandmortyapi.com/graphql")
                    .build();
        }
        return apolloClient;
    }
}
