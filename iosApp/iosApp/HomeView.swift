//
//  HomeView.swift
//  iosApp
//
//  Created by Luke Powell on 7/17/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    var body: some View {
        TabView {
            ScoreCalculatorView()
                .tabItem {
                    Image("calculate")
                    Text("Score Calc")
                }
            Text("404: Cannot Find Hands")
                .tabItem {
                    Image(systemName: "magnifyingglass")
                    Text("Find Hand")
                }
            Text("Record Tab")
                .tabItem {
                    Image(systemName: "gamecontroller.fill")
                    Text("Record Game")
                }
        }
        .font(.headline)
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
