/*
 * Copyright (C) 2021 Julien Roy
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */
package com.github.mc1arke.sonarqube.plugin.almclient.github.v4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.aexp.nodes.graphql.annotations.GraphQLArgument;
import io.aexp.nodes.graphql.annotations.GraphQLProperty;

@GraphQLProperty(name = "repository", arguments = {@GraphQLArgument(name = "owner"), @GraphQLArgument(name = "name")})
public class GetPullRequest {

    private final String url;

    @GraphQLProperty(name = "pullRequest", arguments = {@GraphQLArgument(name = "number")})
    private final PullRequest pullRequest;

    @JsonCreator
    public GetPullRequest(@JsonProperty("url") String url, @JsonProperty("pullRequest") PullRequest pullRequest) {
        this.url = url;
        this.pullRequest = pullRequest;
    }

    public String getUrl() {
        return url;
    }

    public PullRequest getPullRequest() {
        return pullRequest;
    }

    public static class PullRequest {

        private final String id;

        @JsonCreator
        public PullRequest(@JsonProperty("id") String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}
