/*
* References.kt
* match-collection
*
* Created on 1/11/2020
* Copyright 2020 Citrus Circuits. All rights reserved.
*/

package com.example.match_collection

// File to store information to be used to create the final match information map.

// Variables not used in QR compression.
var collection_mode: Constants.MODE_SELECTION = Constants.MODE_SELECTION.NONE
var alliance_color: Constants.ALLIANCE_COLOR = Constants.ALLIANCE_COLOR.NONE
var scout_id: String = ""
var match_time: String = ""

// Data that is shared between the objective and subjective QRs.
var serial_number: String? = ""
var scout_name: String = ""
var match_number: Int = 0
var timestamp: Long = 0

// Data specific to objective match collection QR.
var team_number: String = ""
var timeline: ArrayList<HashMap<String, String>> = ArrayList()

// Subjective relative data collection variables.
var speed_rankings: List<String> = emptyList()
var agility_rankings: List<String> = emptyList()

// Function to reset References.kt variables for new match.
fun resetReferences() {
    scout_name = ""
    scout_id = ""
    timestamp = 0

    team_number = ""
    timeline = ArrayList()

    speed_rankings = emptyList()
    agility_rankings = emptyList()
}
