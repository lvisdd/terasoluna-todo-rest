# terasoluna-todo-rest
## TERASOLUNA Server Framework for Java (5.x) Development Guideline - 5.0.1.RELEASE

http://terasolunaorg.github.io/guideline/

のチュートリアル(Todoアプリケーション REST編)をマルチプロジェクト構成（MyBatis3）をベースに実施した。
また、動作確認用に、AngularJSベースのREST Clientを追加した。

https://github.com/lvisdd/terasoluna-todo-rest/blob/master/todo-web/src/main/webapp/resources/static/restapi-tester.html

主に、以下の手順で作成している。

### 開発プロジェクトの作成
#### terasoluna-gfw-multi-web-blank-mybatis3-archetype
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/ImplementationAtEachLayer/CreateWebApplicationProject.html#id23

### todo-domain
#### ドメイン層の作成
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/TutorialTodo/index.html#id18

#### MyBatis3を使用したインフラストラクチャ層の作成
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/TutorialTodo/index.html#using-mybatis3

### todo-env
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/TutorialTodo/index.html#tutorial-todo-infra

### todo-web
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/TutorialREST/index.html

### ボイラープレートコードの排除(Lombok)
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/Appendix/Lombok.html

### HTTPの仕様に準拠したRESTful Web Serviceの作成
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/ArchitectureInDetail/REST.html#httprestful-web-service

### 例外ハンドリングの実装
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/ArchitectureInDetail/REST.html#resthowtouseexceptionhandling
