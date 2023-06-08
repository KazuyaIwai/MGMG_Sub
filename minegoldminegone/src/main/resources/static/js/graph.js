// グラフ系メソッド群
var GRAPH = {
    initErGraph: function(){
        // let graph = new GRAPH.ergraph(10, 20);
        // graph.test();
        let my100words = new GRAPH.organizationCharts('myselft-100-words');
        my100words.draw();

    },

    ergraph: class {
        constructor(x, y){
            this.x = x;
            this.y = y;
            this.physic = new GRAPH.physicalCalcUtil();
        }
        get getX(){
            return this.x;
        }
        get getY(){
            return this.y;
        }
        set setX(x){
            this.x = x;
        }
        set setY(y){
            this.y = y;
        }

        name(s) {
            return this.x + s;
        }
        test(){
            this.physic.name(this.getX);
        }
    },

    physicalCalcUtil: class {
        constructor(){}
        /*
         * 
         */
        name(a){
            alert(a);
        }
    },

    organizationCharts: class {
        constructor(selector){
            this.selector = selector;
        }
        
        get getSelector(){
            return this.selector;
        }
        set setSelector(selector){
            this.selector = selector;
        }

        draw(){
                Highcharts.chart(this.getSelector, {
                    chart: {
                        height: 1800,
                        inverted: true,
                        // margin: [0, 40, 0, 40]
                    },
                    title: {
                        text: '自分を表す101個の言葉'
                    },
                    series: [{
                            type: 'organization',
                            name: 'Highsoft',
                            hangingIndent: 100,
                            colorByPoint: false,
                            height: 60,
                            color: 'silver',
                            boderColor: 'black',
                            shadow: true,
                            keys: ["from", "to"],
                            data: [
                                ['person', 'my-past'],
                                ['my-past', 'university'],
                                ['university', 'university1'],
                                ['university1', 'university2'],
                                ['university2', 'university3'],
                                ['university3', 'part-time-job'],
                                ['part-time-job', 'part-time-job1'],
                                ['part-time-job1', 'part-time-job2'],
                                ['part-time-job2', 'part-time-job3'],
                                ['part-time-job3', 'come-from'],
                                ['come-from', 'come-from1'],
                                ['come-from1', 'come-from2'],
                                ['come-from2', 'come-from3'],
                                ['person', 'personal-color'],
                                ['personal-color', 'character'],
                                ['character', 'character1'],
                                ['character1', 'character2'],
                                ['character2', 'character3'],
                                ['person', 'job'],
                                ['job', 'program'],
                                ['program', 'well-use-program'],
                                ['well-use-program', 'well-use-program1'],
                                ['well-use-program1', 'well-use-program2'],
                                ['well-use-program2', 'well-use-program3'],
                                ['well-use-program3', 'well-use-program4'],
                                ['person', 'hobby'],
                                ['hobby', 'youtube'],
                                ['youtube', 'youtube-search-history'],
                                ['youtube-search-history', 'youtube-search-history1'],
                                ['youtube-search-history1', 'youtube-search-history2'],
                                ['youtube-search-history2', 'youtube-search-history3'],
                                ['youtube-search-history3', 'youtube-search-history4'],
                                ['youtube-search-history4', 'youtube-search-history5'],
                                ['youtube-search-history5', 'youtube-search-history6'],
                                ['youtube-search-history6', 'youtube-search-history7'],
                                ['youtube-search-history7', 'youtube-search-history8'],
                                ['youtube-search-history8', 'youtube-search-history9'],
                                ['youtube-search-history9', 'youtube-search-history10'],
                                ['youtube-search-history10', 'youtube-search-history11'],
                                ['youtube-search-history11', 'youtube-search-history12'],
                                ['youtube-search-history12', 'youtube-search-history13'],
                                ['youtube-search-history13', 'youtube-search-history14'],
                                ['youtube-search-history14', 'youtube-search-history15'],
                                ['youtube', 'youtube-my-favorite'],
                                ['youtube-my-favorite', 'youtube-my-favorite1'],
                                ['youtube-my-favorite1', 'youtube-my-favorite2'],
                                ['youtube-my-favorite2', 'youtube-my-favorite3'],
                                ['youtube-my-favorite3', 'youtube-my-favorite4'],
                                ['youtube-my-favorite4', 'youtube-my-favorite5'],
                                ['youtube-my-favorite5', 'youtube-my-favorite6'],
                                ['youtube-my-favorite6', 'youtube-my-favorite7'],
                                ['youtube-my-favorite7', 'youtube-my-favorite8'],
                                ['youtube-my-favorite8', 'youtube-my-favorite9'],
                                ['youtube-my-favorite9', 'youtube-my-favorite10'],
                                ['youtube-my-favorite10', 'youtube-my-favorite11'],
                                ['youtube-my-favorite11', 'youtube-my-favorite12'],
                                ['youtube-my-favorite12', 'youtube-my-favorite13'],
                                ['youtube-my-favorite13', 'youtube-my-favorite14'],
                                ['youtube-my-favorite14', 'youtube-my-favorite15'],
                            ],
                            nodes: [
                                {id: 'person',
                                 name: '名前：棟方英悟',
                                 title: '種族：人類', 
                                 color: 'aliceblue'},
                                {id: 'my-past',
                                  name: '自分の過去',
                                  color: '#0099FF'},
                                {id: 'university',
                                 name: '大学時代',
                                 color: '#66CCFF'},
                                {id: 'university1', name: '政治経済学部 経済学科', color: '#99CCFF'},
                                {id: 'university2', name: '計量経済学ゼミナール', color: '#99CCFF'},
                                {id: 'university3', name: '1年間ハーモニカサークル所属', color: '#99CCFF', 
                                layout: "hanging"},
                                {id: 'part-time-job',
                                 name: 'バイト',
                                 color: '#66CCFF'},
                                {id: 'part-time-job1', name: '居酒屋', color: '#99CCFF'},
                                {id: 'part-time-job2', name: '花屋', color: '#99CCFF'},
                                {id: 'part-time-job3', name: '個別教師トライ・家庭教師', color: '#99CCFF'},
                                {id: 'come-from',
                                 name: '出身',
                                 color: '#66CCFF', 
                                 layout: "hanging"},
                                {id: 'come-from1', name: '青森八戸市出身', color: '#99CCFF'},
                                {id: 'come-from2', name: '大学時に上京', color: '#99CCFF'},
                                {id: 'come-from3', name: '実家はお寺', color: '#99CCFF'},

                                {id: 'personal-color',
                                 name: '自分の性格',
                                 color: '#00CC33'},
                                {id: 'character',
                                 name: '気質',
                                 color: '#66CC33'},
                                {id: 'character1', name: '面倒くさがり', color: '#99CC33'},
                                {id: 'character2', name: 'とりあえず実行する', color: '#99CC33'},
                                {id: 'character3', name: '考えすぎちゃう', color: '#99CC33'},

                                {id: 'hobby',
                                 name: '趣味', 
                                 color: '#FFFF00'},
                                {id: 'youtube',
                                 name: 'youtube動画開拓',
                                 color: '#FFFF33'},
                                {id: 'youtube-search-history',
                                 name: '検索履歴(直近15件)', 
                                 color: '#FFFFCC', 
                                 layout: "hanging"},
                                {id: 'youtube-search-history1', name: 'vinland saga', color: '#FFFFCC' },
                                {id: 'youtube-search-history2', name: 'mukanjyo', color: '#FFFFCC'},
                                {id: 'youtube-search-history3', name: 'mhrs', color: '#FFFFCC'},
                                {id: 'youtube-search-history4', name: 'shiver', color: '#FFFFCC'},
                                {id: 'youtube-search-history5', name: "who's ready for tomorrow", color: '#FFFFCC'},
                                {id: 'youtube-search-history6', name: 'バナナムーン', color: '#FFFFCC'},
                                {id: 'youtube-search-history7', name: 'bad apple', color: '#FFFFCC'},
                                {id: 'youtube-search-history8', name: 'me me me', color: '#FFFFCC'},
                                {id: 'youtube-search-history9', name: 'tamanegi sensei', color: '#FFFFCC'},
                                {id: 'youtube-search-history10', name: 'made in abyss', color: '#FFFFCC'},
                                {id: 'youtube-search-history11', name: 'villan', color: '#FFFFCC'},
                                {id: 'youtube-search-history12', name: 'chainsow man kobeni', color: '#FFFFCC'},
                                {id: 'youtube-search-history13', name: 'ななち', color: '#FFFFCC'},
                                {id: 'youtube-search-history14', name: 'splatoon dance', color: '#FFFFCC'},
                                {id: 'youtube-search-history15', name: 'なると 20th', color: '#FFFFCC'},
                                {id: 'youtube-search-history16', name: 'テンタクルズ', color: '#FFFFCC'},
                                {id: 'youtube-search-history17', name: '狼と香辛料', color: '#FFFFCC'},
                                {id: 'youtube-search-history18', name: 'かまいたち　コント', color: '#FFFFCC'},
                                {id: 'youtube-search-history19', name: '見取り図', color: '#FFFFCC'},
                                {id: 'youtube-search-history20', name: 'デスフォレスト　かいばしら', color: '#FFFFCC'},
                                {id: 'youtube-my-favorite',
                                 name: '登録チャンネル(抜粋15件)', 
                                 color: 'aliceblue', 
                                 color: '#FFFFAA', 
                                 layout: "hanging"},
                                {id: 'youtube-my-favorite1', name: '28チャンネル', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite2', name: 'サカナクション sakanaction', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite3', name: '慶應義塾 Keio University', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite4', name: 'StatQuest with Josh Starmer', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite5', name: '予備校のノリで学ぶ「大学の数学・物理」', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite6', name: 'wheel350', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite7', name: 'ポルカドットスティングレイ', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite8', name: 'ケンドラ・ランゲージ・スクール', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite9', name: '/谷やん 谷崎鷹人', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite10', name: 'NO BUSES BAND', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite11', name: 'まーやの料理ちゃんねる', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite12', name: 'オメでたい頭でなにより', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite13', name: '吉田製作所', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite14', name: '非株式会社いつかやる', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite15', name: '庭池日記', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite16', name: 'ちょっと世界一周してくる', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite17', name: 'バーバパパ', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite18', name: 'DJ OKAWARI OFFICIAL', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite19', name: 'ピーナッツくん!オシャレになりたい!', color: '#FFFFAA'},
                                {id: 'youtube-my-favorite20', name: '山田五郎 大人の教養講座', color: '#FFFFAA'},
                                {id: 'job',
                                 name: '仕事', 
                                 color: '#FF9900'},
                                {id: 'program',
                                 name: 'プログラム関連', 
                                 color: '#FFCC00'},
                                {id: 'well-use-program',
                                 name: '好きなPG言語ランキング', 
                                 color: '#FFCC66', 
                                 layout: "hanging"},
                                {id: 'well-use-program1', name: '①, Java', color: '#FFCC66'},
                                {id: 'well-use-program2', name: '①, Python', color: '#FFCC66'},
                                {id: 'well-use-program3', name: '②, JavaScript(Canvas)', color: '#FFCC66'},
                                {id: 'well-use-program4', name: '③, SQL', color: '#FFCC66'},
                                {id: 'well-use-program5', name: '', color: '#FFCC66'},
                            ],
                        }
                    ]
            })
        }
    }
};