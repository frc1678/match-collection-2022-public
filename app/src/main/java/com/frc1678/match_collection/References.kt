// Copyright (c) 2019 FRC Team 1678: Citrus Circuits
package com.frc1678.match_collection

import android.os.CountDownTimer

// File to store information to be used to create the final match information map.
var numActionOne = 0 //SCORE_BALL_LOW
var numActionTwo = 0 //SCORE_BALL_HIGH
var numActionFour = 0 //SCORE_BALL_HIGH_OTHER
var numActionFive = 0 //NUMBER OF INTAKES

var match_timer: CountDownTimer? = null
var match_time: String = ""
var is_teleop_activated: Boolean = false
var popup_open = false
var is_match_time_ended: Boolean = false
var collection_mode: Constants.ModeSelection = Constants.ModeSelection.NONE
var assign_mode: Constants.AssignmentMode = Constants.AssignmentMode.NONE
var did_climb: Boolean = false

// Data that is shared between the objective and subjective QRs.
var serial_number: String? = ""
var match_number: Int = 0
var alliance_color: Constants.AllianceColor = Constants.AllianceColor.NONE
var timestamp: Long = 0
var match_collection_version_number: String = "5.0.0"
var scout_name: String = Constants.NONE_VALUE

// Data specific to Objective Match Collection QR.
var team_number: String = ""
var scout_id: String = Constants.NONE_VALUE
var orientation: Boolean = true //true = UP, false = DOWN
var starting_position: Constants.StartingPosition = Constants.StartingPosition.NONE
var timeline: ArrayList<HashMap<String, String>> = ArrayList()
var climb_level: Constants.ClimbLevel = Constants.ClimbLevel.NONE


// Data specific to Subjective Match Collection QR.
var quickness_score: SubjectiveTeamRankings = SubjectiveTeamRankings()
var field_awareness_score: SubjectiveTeamRankings = SubjectiveTeamRankings()
var played_defense_list: ArrayList<String> = ArrayList()

// Function to reset References.kt variables for new match.
fun resetCollectionReferences() {
    numActionOne = 0
    numActionTwo = 0
    numActionFour = 0
    numActionFive = 0

    is_teleop_activated = false
    did_climb = false

    popup_open = false
    climb_level = Constants.ClimbLevel.NONE

    timestamp = 0

    timeline = ArrayList()

    quickness_score = SubjectiveTeamRankings()
    field_awareness_score = SubjectiveTeamRankings()
    played_defense_list = ArrayList()
}

data class SubjectiveTeamRankings(
    val teamOne: TeamRank? = null,
    val teamTwo: TeamRank? = null,
    val teamThree: TeamRank? = null
) {
    val list: List<TeamRank?>
        get() = listOf(teamOne, teamTwo, teamThree)

    val notNullList: List<TeamRank>
        get() = this.list.filterNotNull()


    fun hasDuplicate(): Boolean {
        val ranks = mutableListOf<Int>()
        for (team in this.notNullList) {
            ranks.add(team.rank)
        }
        return ranks.toSet().toList() != ranks
    }
}

data class TeamRank(var teamNumber: String, val rank: Int)

fun resetStartingReferences() {
    starting_position = Constants.StartingPosition.NONE
    team_number = ""
}
