package com.datarockets.mnchkn.data.model

data class Player(var id: Long,
                  val name: String,
                  var levelScore: Int,
                  var strengthScore: Int,
                  var totalScore: Int,
                  val color: String
)
