var yearVal = new Date().getFullYear();

var portalHeader = `<header id="header-full-top" class="hidden-xs header-full">
                <div class="container">
                    <div class="header-full-title">
                        <h1 class="animated fadeInRight"><a href="/astarta-portal/html/index.html">Astarta <span>-Kyiv</span></a></h1>
                        <p class="animated fadeInRight">agroindustrial holding</p>
                    </div>
                    <div class="top-nav">
                        <nav>
                            <ul class="top-nav-social hidden-sm">
                                <li><a href="https://twitter.com/astartakyiv" class="animated fadeIn animation-delay-7 twitter"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="https://ru-ru.facebook.com/Astarta-Kyiv-1417585695160789/" class="animated fadeIn animation-delay-8 facebook"><i class="fa fa-facebook"></i></a></li>
                            </ul>
    
                            <div id="loginContainer" class="dropdown animated fadeInDown animation-delay-11">
                            	
                            		<a id="loginLink" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Login</a>
                            			<div class="dropdown-menu dropdown-menu-right dropdown-login-box animated flipCenter">
                            			<form id="loginForm" role="form">  
                                			<h4>Login Form</h4>
    
	                                        <div class="form-group">
	                                            <div class="input-group login-input">
	                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
	                                                <input name="app_username" type="text" class="form-control" placeholder="Username" required="true">
	                                            </div>
	                                            <br>
	                                            <div class="input-group login-input">
	                                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
	                                                <input name="app_password" type="password" class="form-control" placeholder="Password" required="true">
	                                            </div>
	                                            <div class="checkbox pull-left">
	                                                <input type="checkbox" id="rememberMeId" name="_spring_security_remember_me">
	                                                <label for="rememberMeId">
	                                                    Remember me
	                                                </label>
	                                            </div>
	                                            <button id="loginBtn" type="button" class="btn btn-ar btn-primary pull-right">Login</button>
	                                            <div class="clearfix"></div>
	                                           </div>
	                                        </form>
	                                   </div>
                                
                            </div> <!-- dropdown -->
    
                            <div class="dropdown animated fadeInDown animation-delay-13">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-search"></i></a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-search-box animated fadeInUp">
                                    <form role="form">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Search...">
                                            <span class="input-group-btn">
                                        <button class="btn btn-ar btn-primary" type="button">Go!</button>
                                    </span>
                                        </div><!-- /input-group -->
                                    </form>
                                </div>
                            </div> <!-- dropdown -->
                        </nav>
                        <span id="authText"></span>
                    </div>    
                </div> <!-- container -->
            </header> <!-- header-full -->
            <nav class="navbar navbar-default navbar-header-full navbar-dark yamm navbar-static-top" role="navigation" id="header">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <i class="fa fa-bars"></i>
                        </button>
                        <a id="ar-brand" class="navbar-brand hidden-lg hidden-md hidden-sm" href="index.html">Artificial <span>Reason</span></a>
                    </div> <!-- navbar-header -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="pull-right">
                        <a href="javascript:void(0);" class="sb-icon-navbar sb-toggle-right"><i class="fa fa-bars"></i></a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" aria-expanded="false">Головна</a>
                                <ul class="dropdown-menu dropdown-menu-left animated-2x animated fadeIn">
                                    <li><a href="#">Новини холдингу <span class="label label-success pull-right">News</span></a></li>
                                    <li><a href="#">Дошка оголошень</a></li>
                                    <li><a href="#">Каталог підприємств</a></li>
                                    <li><a href="#">Рейтинг підприємств</a></li>
                                    <li><a href="#">Річні звіти</a></li>
                                    <li><a href="#">Інновації</a></li>
                                    <li><a href="#">Страхування</a></li>
                                    <li role="presentation" class="dropdown-header">Контакти</li>
                                    <li><a href="#">Співробітники <span class="label label-success pull-right"><i class="fa fa-phone-square" aria-hidden="true"></i></span></a></li>
                                    <li><a href="#">Підприємства <span class="label label-success pull-right"><i class="fa fa-phone-square" aria-hidden="true"></i></span></a></li>
                                </ul>
                            </li>
                            <li class="dropdown yamm-fw">
                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" aria-expanded="false">Інструменти</a>
                                <ul class="dropdown-menu dropdown-menu-left animated-2x animated fadeIn" style="">
                                    <li style="">
                                        <div class="yamm-content" style="">
                                            <div class="row" style="">
                                                <div class="col-lg-3 col-md-6 col-sm-6 col-megamenu" style="height: 334px;">
                                                    <div class="megamenu-block">
                                                        <h4 class="megamenu-block-title"><i class="fa fa-hand-o-up"></i> Адміністрація</h4>
                                                        <ul>
                                                            <li role="presentation" class="dropdown-header">Календар подій</li>
                                                            <li><a href="#"><i class="fa fa-calendar" aria-hidden="true"></i> Центр. офіс</a></li>
                                                            <li><a href="#"><i class="fa fa-calendar" aria-hidden="true"></i> Підприємства</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="megamenu-block">
                                                        <h4 class="megamenu-block-title"><i class="fa fa-hand-o-up"></i> Фінансове управління</h4>
                                                        <ul>
                                                            <li><a href="#"><i class="fa fa-file-o" aria-hidden="true"></i> Місячна звітність <span class="label label-success pull-right"><i class="fa fa-file-excel-o" aria-hidden="true"></i></span></a></li>
                                                            <li><a href="#"><i class="fa fa-file-o" aria-hidden="true"></i> Річна звітність <span class="label label-info pull-right"><i class="fa fa-file-excel-o" aria-hidden="true"></i></span></a></li>
                                                            <li><a href="#"><i class="fa fa-file-text-o" aria-hidden="true"></i> Звіт керівнику</a></li>
                                                            <li><a href="#"><i class="fa fa-bar-chart" aria-hidden="true"></i> Аналіз даних</a></li>
                                                            <li><a href="#"><i class="fa fa-table" aria-hidden="true"></i> Ститистика</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-md-6 col-sm-6 col-megamenu" style="height: 334px;">
                                                    <div class="megamenu-block">
                                                        <h4 class="megamenu-block-title"><i class="fa fa-hand-o-up"></i> HR-управління</h4>
                                                        <ul>
                                                            <li><a href="#"><i class="fa fa-file-o" aria-hidden="true"></i> Звітність <span class="label label-success pull-right"><i class="fa fa-file-excel-o" aria-hidden="true"></i></span></a></li>
                                                            <li><a href="#"><i class="fa fa-arrow-circle-right"></i> Атестація персоналу</a></li>
                                                            <li><a href="#"><i class="fa fa-tasks" aria-hidden="true"></i> Заявки на пошук персоналу</a></li>
                                                            <li><a href="#"><i class="fa fa-calendar" aria-hidden="true"></i> Календар подій</a></li>
                                                            <li><a href="#"><i class="fa fa-twitter"></i> Пропозиції</a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="megamenu-block">
                                                        <h4 class="megamenu-block-title"><i class="fa fa-hand-o-up"></i> Бухгалтерія</h4>
                                                        <ul>
                                                            <li><a href="#"><i class="fa fa-file-o" aria-hidden="true"></i> Місячна звітність <span class="label label-success pull-right"><i class="fa fa-file-excel-o" aria-hidden="true"></i></span></a></li>
                                                            <li><a href="#"><i class="fa fa-file-o" aria-hidden="true"></i> Річна звітність <span class="label label-info pull-right"><i class="fa fa-file-excel-o" aria-hidden="true"></i></span></a></li>
                                                            <li><a href="#"><i class="fa fa-university" aria-hidden="true"></i> Семінари</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="col-lg-3 col-md-6 col-sm-6 col-megamenu" style="height: 334px;">
                                                    <div class="megamenu-block">
                                                        <h4 class="megamenu-block-title"><i class="fa fa-hand-o-up"></i> IT-управління</h4>
                                                        <ul>
                                                            <li><a href="#"><i class="fa fa-list" aria-hidden="true"></i> Проекти</a></li>
                                                            <li><a href="#"><i class="fa fa-file-excel-o" aria-hidden="true"></i> Інвентаризація</a></li>
                                                            <li><a href="#"><i class="fa fa-university" aria-hidden="true"></i> Семінари</a></li>
                                                            <li><a href="#"><i class="fa fa-car" aria-hidden="true"></i> Відрядження</a></li>
                                                            <li><a href="#"><i class="fa fa-flag-o"></i> 1С</a></li>
                                                            <li><a href="#"><i class="fa fa-life-ring" aria-hidden="true"></i> СТО</a></li>
                                                            <li><a href="#"><i class="fa fa-tags" aria-hidden="true"></i> Пропозиції</a></li>
                                                            <li><a href="#"><i class="fa fa-square"></i> База документів</a></li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <div class="col-lg-3 col-md-6 col-sm-6 col-megamenu" style="height: 334px;">
                                                    <div class="megamenu-block">
                                                        <h4 class="megamenu-block-title"><i class="fa fa-hand-o-up"></i> Загальна</h4>
                                                        <ul>
                                                            <li><a href="#"><i class="fa fa-envelope" aria-hidden="true"></i> Залишити звернення</a></li>
                                                            <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i> Заявка на пошук персонала</a></li>
                                                            <li><a href="#"><i class="fa fa-ambulance" aria-hidden="true"></i> Страхування</a></li>
                                                            <li><a href="#"><i class="fa fa-info" aria-hidden="true"></i> Допомога</a></li>
                                                            <li><a href="#"><i class="fa fa-files-o" aria-hidden="true"></i> Заявка на загальну поштову розсилку</a></li>
                                                            <li><a href="#"><i class="fa fa-search"></i> Перейти до OTRS</a></li>
                                                            <li><a href="#"><i class="fa fa-opencart"></i> Перейти до Alfresco</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">Сторінки</a>
                                <ul class="dropdown-menu dropdown-menu-left animated-2x animated fadeIn">
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Інформація для співробітників</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Відомість по зарплаті</a></li>
                                            <li><a href="#">Кількість відпускних днів</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Закріплені ТМЦ</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Альбом</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Наші обличчя</a></li>
                                            <li role="presentation" class="dropdown-header">Підсумки року</li>
                                            <li><a href="#">2013 рік</a></li>
                                            <li><a href="#">2014 рік</a></li>
                                            <li><a href="#">2015 рік</a></li>
                                            <li><a href="#">2016 рік</a></li>
                                            <li role="presentation" class="dropdown-header">Корпоративи</li>
                                            <li><a href="#">2015 рік</a></li>
                                            <li><a href="#">2016 рік</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Резервування автотранспорту</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Оформити заявку</a></li>
                                            <li><a href="#">Сервіс резервування</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Резервування кімнати для переговорів</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Оформити заявку</a></li>
                                            <li><a href="#">Сервіс резервування</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">База документів</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Юридичні</a></li>
                                            <li><a href="#">Фінансові</a></li>
                                            <li><a href="#">Бухгалтерські</a></li>
                                            <li><a href="#">Кадрові</a></li>
                                            <li><a href="#">Технічні</a></li>
                                            <li><a href="#">Зразки заяв</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Реєстрація документів</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Заявка на реєстрацію</a></li>
                                            <li><a href="#">Перелік зареєстрованих</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Конфлікти</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Анкета</a></li>
                                            <li><a href="#">Скарга</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Телефонні конференції</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Заявка в IT</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown-submenu">
                                        <a href="javascript:void(0);" class="has_children">Групові розсилки EMAIL, SMS</a>
                                        <ul class="dropdown-menu dropdown-menu-left">
                                            <li><a href="#">Заявка на розсилку</a></li>
                                            <li><a href="#">Виконані групові розсилки</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" aria-expanded="false">Блог</a>
                                <ul class="dropdown-menu dropdown-menu-left animated-2x animated fadeIn">
                                    <li><a href="#">Обговорення нових проектів</a></li>
                                    <li><a href="#">Цукрове виробництво</a></li>
                                    <li><a href="#">Сільське господарство</a></li>
                                    <li><a href="#">Звітність <span class="label label-success pull-right"><i class="fa fa-file-excel-o" aria-hidden="true"></i></span></a></li>
                                    <li><a href="#">Страхування</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Відпочинок</a></li>
                                    <li><a href="#">Новини</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" aria-expanded="false">Профіль</a>
                                <ul class="dropdown-menu dropdown-menu-left animated-2x animated fadeIn">
                                    <li><a href="#">Картка користувача</a></li>
                                    <li><a href="#">Мої налаштування</a></li>
                                    <li><a href="#">Змінити пароль</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Вихід <span class="label label-success pull-right"><i class="fa fa-sign-out" aria-hidden="true"></i></span></a></li>
                                </ul>
                            </li>
                        </ul>
                    </div><!-- navbar-collapse -->
                </div><!-- container -->
            </nav>
`;

var portalWorkspace = `
          <section class="wrap-hero margin-bottom">
                <div id="carousel-example-ny" class="carousel carousel-hero slide" data-ride="carousel" data-interval="9000">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-ny" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-ny" data-slide-to="1" class=""></li>
                        <li data-target="#carousel-example-ny" data-slide-to="2" class=""></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6 col-md-push-6">
                                        <div class="">
                                            <!--<img src="" alt="" class="img-responsive animated zoomInUp animation-delay-30">-->
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-md-pull-6">
                                        <div class="carousel-caption">
                                            <h1 class="animated fadeInDownBig animation-delay-7 carousel-title">Більше ніж <span> 10 000 співробітників</span> забезпечують:</h1>
                                            <ul class="list-unstyled carousel-list">
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-11"></i><span class="animated fadeInRightBig animation-delay-13">Вирощування буряку, <strong> зернових </strong>, і олійних культур.</span></li>
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-15"></i><span class="animated fadeInRightBig animation-delay-16">Виробництво <strong>високоякісного цукру</strong> та супутньої продукції.</span></li>
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-19"></i><span class="animated fadeInRightBig animation-delay-19">Виробництво <strong> молока </strong>і м’яса.</span></li>
                                            </ul>
                                            <p class="animated zoomIn animation-delay-20">Високий кадровий потенціал дозволяє використовувати високоефективну техніку <span>, якою забезпечені агрофірми</span> холдингу.</p>
                                            <div class="action-zone">
                                                <a href="#" class="btn btn-ar btn-transparent-opaque btn-xl animated fadeInUp animation-delay-22"><i class="fa fa-opencart"></i> Alfresco</a>
                                                <a href="#" class="btn btn-ar btn-transparent-opaque btn-xl animated fadeInUp animation-delay-25"><i class="fa fa-search"></i> OTRS</a>
                                            </div>
                                        </div>
                                    </div>
                                </div> <!--row -->
                            </div> <!-- container -->
                        </div> <!-- item -->

                        <div class="item">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6 col-md-push-6">
                                        <div class="carousel-object">
                                            <!--       <img src="assets/img/demo/wire1.png" class="img-responsive base animated animated-slow reveal animation-delay-25" alt="Image">
                                                   <img src="assets/img/demo/wire1.png" class="img-responsive relative animated animated-slow reveal animation-delay-25" alt="Image">
                                                   <img src="assets/img/demo/wire1shadow.png" class="img-responsive relative animated fadeIn animation-delay-40" alt="Image">
                                                   <img src="assets/img/demo/wire1capture.png" class="img-responsive relative animated fadeIn animation-delay-45" alt="Image">-->
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-md-pull-6">
                                        <div class="carousel-caption">
                                            <h1 class="animated fadeInDownBig animation-delay-7 carousel-title">Місія та цінності <span>наших співробітників</span></h1>
                                            <ul class="list-unstyled carousel-list">
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-11"></i><span class="animated fadeInRightBig animation-delay-13">Прагнути неможливого, <strong>щоб досягати</strong> максимального.</span></li>
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-15"></i><span class="animated fadeInRightBig animation-delay-16">Працювати єдиною командою, <strong>у якій кожний</strong> – професіонал.</span></li>
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-19"></i><span class="animated fadeInRightBig animation-delay-19">Піклуватись про світ <strong> навколо нас </strong>.</span></li>
                                            </ul>
                                            <p class="animated zoomIn animation-delay-20">З духовністю до земного: стверджуючи вічні цінності, розвиваємо і  <span>використовуємо потенціал Землі</span>.</p>
                                            <div class="action-zone">
                                                <a href="#" class="btn btn-ar btn-transparent-opaque btn-xl animated fadeInUp animation-delay-22"><i class="fa fa-opencart"></i> Alfresco</a>
                                                <a href="#" class="btn btn-ar btn-transparent-opaque btn-xl animated fadeInUp animation-delay-25"><i class="fa fa-search"></i> OTRS</a>
                                            </div>
                                        </div>
                                    </div>
                                </div> <!--row -->
                            </div> <!-- container -->
                        </div> <!-- item -->

                        <div class="item">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6 col-md-push-6">
                                        <div class="">
                                            <!--<img src="assets/img/demo/mockup3.png" alt="" class="img-responsive animated zoomInRight animation-delay-30">-->
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-md-pull-6">
                                        <div class="carousel-caption">
                                            <h1 class="animated fadeInDownBig animation-delay-7 carousel-title">АСТАРТА – <span>вертикально-інтегрований</span><span> холдинг</span></h1>
                                            <ul class="list-unstyled carousel-list">
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-11"></i><span class="animated fadeInRightBig animation-delay-13">Лідер у виробництві цукру.</span></li>
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-15"></i><span class="animated fadeInRightBig animation-delay-16">Найбільший <strong> виробник </strong> молока.</span></li>
                                                <li class=""><i class="fa fa-angle-right animated fadeIn animation-delay-19"></i><span class="animated fadeInRightBig animation-delay-19"><strong>Ведучий </strong>переробник сої</span></li>
                                            </ul>
                                            <p class="animated zoomIn animation-delay-20">АСТАРТА застосовує науково обгрунтований підхід до сівозміни.<span> Основні культури:</span>цукровий буряк, пшениця, ячмінь, соя та кукуруза.</p>
                                            <div class="action-zone">
                                                <a href="#" class="btn btn-ar btn-transparent-opaque btn-xl animated fadeInUp animation-delay-22"><i class="fa fa-opencart"></i> Alfresco</a>
                                                <a href="#" class="btn btn-ar btn-transparent-opaque btn-xl animated fadeInUp animation-delay-25"><i class="fa fa-search"></i> OTRS</a>
                                            </div>
                                        </div>
                                    </div>
                                </div> <!--row -->
                            </div> <!-- container -->
                        </div> <!-- item -->
                    </div> <!-- carousel-inner -->

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-ny" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-ny" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>
                </div>
            </section> <!-- carousel -->

            <div class="container">
                <section class="margin-bottom">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 id="go-to-category-h2" class="right-line">Категорії інформаційних ресурсів компанії:</h2>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-cloud"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="user-info-h3" class="no-margin">Інформація для співробітників</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel('userInfo')"><span id="user-info-label" class="category-label">Інформація матеріального, технічного, фінансового характеру, що стосується співробітника холдингу.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-desktop"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="albom-h3" class="no-margin">Альбом</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="albom-label" class="category-label">Фото галерея холдингу. Довідник співробітників центрального офісу "Астарта-Київ" з фотографіями.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-wordpress"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="car-reserve-h3" class="no-margin">Резервування автотранспорту</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="car-reserve-label" class="category-label">Порядок використання службового легкового автомобіля. Сервіс резервування автотранспорта.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-tablet"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="room-reserve-h3" class="no-margin">Резервування кімнати для переговорів</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="room-reserve-label" class="category-label">Сервіс резервування кімнат для переговорів і аудіовізуального обладнання.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-paper-plane-o"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="data-base-h3" class="no-margin">База документів</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="data-base-label" class="category-label">База установчих документів і протоколів підприємств агропромхолдингу "Астарта-Київ".</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-paper-plane-o"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="reg-docs-h3" class="no-margin">Реєстрація документів</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="reg-docs-label" class="category-label">Сервіс регістрації документів фінансового, технічного, економічного характеру.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-paper-plane-o"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="conflicts-h3" class="no-margin">Конфлікти</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="conflicts-label" class="category-label">Анкетування умов виникнення конфлікту інтересів.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-paper-plane-o"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="phone-conf-h3" class="no-margin">Телефонні конференції</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="phone-conf-label" class="category-label">Перелік конференцій для моніторингу. Інструкція по користуванню Grandstream GXP1400/1405.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6 category">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-lg"><i class="fa fa-graduation-cap"></i></span>
                                <div class="text-icon-content">
                                    <h3 id="grp-mail-h3" class="no-margin">Групові розсилки EMAIL, SMS</h3>
                                    <p class="open-category">
                                        <button type="button" class="btn-link btn-category" onclick="resourcePanel.openResPanel(undefined)"><span id="grp-mail-label" class="category-label">Сервіс групової розсилки повідомлень електронною поштою, SMS усім клієнтам чи свіпробітникам.</span>
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div> <!-- row -->
                </section>

            </div> <!-- container -->

            <section class="section-lines">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 padding-40">
                            <p class="slogan text-center no-margin">Сьогодні пріоритети Холдингу полягають у подальшому <span>розвитку</span>.Наші принципи <span>творчість</span>, <span>інновації</span>, <span>досвід</span> і <span>знання</span>. Ми спираємося на 20-річний <span>досвід</span>.</p>
                        </div>
                    </div>
                </div>
            </section>

            <div class="container margin-bottom">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="right-line no-margin-bottom">Про Компанію</h2>
                    </div>
                    <div class="col-md-6 animated fadeInLeft animation-delay-8">
                        <h3>Опис</h3>
                        <p class="animated">АСТАРТА – вертикально-інтегрований агропромисловий холдинг, який з 1993 року працює у сфері цукрового та сільськогосподарського виробництва, зарекомендувавши себе як стабільна, прозора компанія, надійний партнер та постачальник.</p>
                        <p>Основна діяльність Агропромхолдингу полягає у вирощуванні буряку, зернових і олійних культур, виробництві високоякісного цукру та супутньої продукції (меляса та сухий гранульований жом), а також молока і м’яса. Крім того, в Полтавській області АСТАРТА має потужності із переробки сої (завод із переробки сої в м. Глобине) та виробництва біогазу (Біоенергетичний комплекс в м. Глобино).</p>
                        <p>У Холдингу створено повний цикл цукрового виробництва: від вирощування буряку до виробництва цукру. Наявність сировинної бази істотно знижує залежність від зовнішніх постачань буряку, зменшує собівартість виробленого цукру, гарантує безперебійність виробництва і максимальний вихід якісного готового продукту. </p>
                        <p>АСТАРТА застосовує науково обґрунтований підхід до сівозміни. Основними культурами для Холдингу, окрім цукрового буряку, є пшениця, ячмінь, соя та кукурудза. Агрофірми обладнані високоефективною технікою – її  парк налічує понад 3000 одиниць. Завдяки використанню сучасної сільськогосподарської техніки, застосуванню передових агротехнологій та оптимальній сівозміні постійно покращується якість ґрунту, підвищується врожайність основних культур.</p>
                    </div>
                    <div class="col-md-6">
                        <h3>Ключові гравці українського сахарного ринку</h3>
                        <div class="progress progress-lg animated fadeInUp animation-delay-6">
                            <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 35%;">
                                Astarta (25%)
                            </div>
                        </div>
                        <div class="progress progress-lg animated fadeInUp animation-delay-8">
                            <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                Ukrprominvest (14%)
                            </div>
                        </div>
                        <div class="progress progress-lg animated fadeInUp animation-delay-10">
                            <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 27%">
                                Radekhov-tsukor (13%)
                            </div>
                        </div>
                        <div class="progress progress-lg animated fadeInUp animation-delay-12">
                            <div class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 18%">
                                Svitanok (8%)
                            </div>
                        </div>
                        <div class="progress progress-lg animated fadeInUp animation-delay-14">
                            <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 14%">
                                Gals LTD (4%)
                            </div>
                        </div>
                        <div class="progress progress-lg animated fadeInUp animation-delay-16">
                            <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 46%">
                                Other (36%)
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- container -->

            <div class="container">
                <section class="css-section">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="right-line">Річний звіт 2015. Ключові факти.</h2>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="content-box box-default wow zoomInUp animation-delay-2" style="visibility: hidden; animation-name: none;">
                                <h4 id="count-dohod" class="content-box-title counter numscroller roller-title-number-1 scrollzip" data-slno="1" data-min="0" data-max="314" data-delay="5" data-increment="1">0</h4>
                                <i class="fa fa-4x fa-file-excel-o primary-color"></i>
                                <p class="margin-top-20 no-margin-bottom lead small-caps">доходи(млн. євро)</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="content-box box-default wow zoomInUp animation-delay-4" style="visibility: hidden; animation-name: none;">
                                <h4 id="count-valprybyl" class="content-box-title counter numscroller roller-title-number-2 scrollzip" data-slno="2" data-min="0" data-max="143" data-delay="5" data-increment="1">0</h4>
                                <i class="fa fa-4x fa-bar-chart primary-color"></i>
                                <p class="margin-top-20 no-margin-bottom lead small-caps">валовий прибуток(млн. євро)</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="content-box box-default wow zoomInUp animation-delay-6" style="visibility: hidden; animation-name: none;">
                                <h4 id="count-ebidta" class="content-box-title counter numscroller roller-title-number-3 scrollzip" data-slno="3" data-min="0" data-max="131" data-delay="5" data-increment="1">0</h4>
                                <i class="fa fa-4x fa-bars primary-color"></i>
                                <p class="margin-top-20 no-margin-bottom lead small-caps">EBITDA(млн. євро)</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="content-box box-default wow zoomInUp animation-delay-8" style="visibility: hidden; animation-name: none;">
                                <h4 id="count-clean-prybyl" class="content-box-title counter numscroller roller-title-number-4 scrollzip" data-slno="4" data-min="0" data-max="16" data-delay="5" data-increment="1">0</h4>
                                <i class="fa fa-4x fa-calculator primary-color"></i>
                                <p class="margin-top-20 no-margin-bottom lead small-caps">чистий прибуток(млн. євро)</p>
                            </div>
                        </div>
                    </div>
                </section>
            </div> <!-- container -->

             <div class="container">
                <h2 class="right-line">Наша команда</h2>
                <div class="row">
                    <div class="col-sm-6 col-md-3">
                        <div class="panel panel-default panel-card wow fadeInRight animation-delay-2" style="visibility: hidden; animation-name: none;">
                            <div class="panel-heading">
                                <img src="/astarta-portal/resources/img/card1.jpg">
                                <button class="btn btn-primary btn-ar btn-sm" role="button">Перейти</button>
                            </div>
                            <div class="panel-figure">
                                <img class="img-responsive img-circle" src="/astarta-portal/resources/img/albom/ourfaces/users.png">
                            </div>
                            <div class="panel-body text-center">
                                <h4 class="panel-header"><span>Наші обличчя</span></h4>
                                <small>Фотоальбом співробітників холдингу.</small>
                            </div>
                            <div class="panel-thumbnails">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/ourfaces/SeredaLesia.jpg">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/ourfaces/UsatenkoIgor.jpg">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/ourfaces/TauzhnyanskaOksana.jpg">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="panel panel-default panel-card wow fadeInRight animation-delay-4" style="visibility: hidden; animation-name: none;">
                            <div class="panel-heading">
                                <img src="/astarta-portal/resources/img/card2.jpg">
                                <button class="btn btn-primary btn-ar btn-sm" role="button">Перейти</button>
                            </div>
                            <div class="panel-figure">
                                <img class="img-responsive img-circle" src="/astarta-portal/resources/img/albom/results2016/ALT_3319.gif">
                            </div>
                            <div class="panel-body text-center">
                                <h4 class="panel-header"><span>Підсумки 2016</span></h4>
                                <small>Підведення підсумків за 2016 рік.</small>
                            </div>
                            <div class="panel-thumbnails">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/results2016/ALT_3319.gif">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/results2016/ALT_3383.gif">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/results2016/ALT_3468.gif">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="panel panel-default panel-card wow fadeInRight animation-delay-6" style="visibility: hidden; animation-name: none;">
                            <div class="panel-heading">
                                <img src="/astarta-portal/resources/img/card3.jpg">
                                <button class="btn btn-primary btn-ar btn-sm" role="button">Перейти</button>
                            </div>
                            <div class="panel-figure">
                                <img class="img-responsive img-circle" src="/astarta-portal/resources/img/albom/IPO/_ALT7344.gif">
                            </div>
                            <div class="panel-body text-center">
                                <h4 class="panel-header"><span>IPO 10 років</span></h4>
                                <small>Зустріч з нагоди 10 річчя IPO</small>
                            </div>
                            <div class="panel-thumbnails">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/IPO/_ALT7350.gif">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/IPO/_ALT7361.gif">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/IPO/_ALT7404.gif">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="panel panel-default panel-card wow fadeInRight animation-delay-8" style="visibility: hidden; animation-name: none;">
                            <div class="panel-heading">
                                <img src="/astarta-portal/resources/img/card4.jpg">
                                <button class="btn btn-primary btn-ar btn-sm" role="button">Перейти</button>
                            </div>
                            <div class="panel-figure">
                                <img class="img-responsive img-circle" src="/astarta-portal/resources/img/albom/vyshyvana/_AVR1221.gif">
                            </div>
                            <div class="panel-body text-center">
                                <h4 class="panel-header"><span>Астарта "Вишивана"</span></h4>
                                <small>Святкування з нагоди для вишиванки.</small>
                            </div>
                            <div class="panel-thumbnails">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/vyshyvana/_AVR1221.gif">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/vyshyvana/_AVR1256.gif">
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="thumbnail">
                                            <img src="/astarta-portal/resources/img/albom/vyshyvana/_AVR1268.gif">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <section class="margin-top">
                    <p class="slogan text-center">Ключові пріоритети АСТАРТИ на 2016 рік - стати ще більш конкурентоспроможними <span>і ефективними</span>. Наші принципи <span>творчість</span>, <span>культура</span>, <span>досвід</span> і <span>знання</span>. Ми спираємось на 20 - річний <span>досвід</span>.</p>
                    <h2 class="section-title">Членство у асоціаціях та організаціях</h2>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="bxslider-controls">
                                <span id="bx-prev5"><a class="bx-prev" href="">&lt;</a></span>
                                <span id="bx-next5"><a class="bx-next" href="">&gt;</a></span>
                            </div>
                            <div class="bx-wrapper" style="max-width: 100%;"><div class="bx-viewport" aria-live="polite" style="width: 100%; overflow: hidden; position: relative; height: 166px;"><ul class="bxslider" id="home-block" style="width: 4215%; position: relative; transition-duration: 0s; transform: translate3d(-555px, 0px, 0px);"><li style="float: left; list-style: none; position: relative; width: 555px;" class="bx-clone" aria-hidden="true">
                                <blockquote class="blockquote-color">
                                    <p>Операція компанії Fairfax Financial Holdings Limited (Торонто, Канада) з придбання більше 25% акцій Astarta Holding N.V. (Амстердам, Нідерланди) може бути завершена в найближчі три-чотири місяці.</p>
                                    <footer>Віктор Іванчик, генеральний директор «Астарта-Київ»</footer>
                                </blockquote>
                            </li>
                                <li style="float: left; list-style: none; position: relative; width: 555px;" aria-hidden="false">
                                    <blockquote class="blockquote-color">
                                        <p>Сьогодні, 30 листопада, в києві відбувся позачерговий з'їзд Української аграрної конфедерації. За результатами голосування, одностайно було прийнято рішення про переобрання Леоніда Козаченка президентом Української аграрної конфедерації.</p>
                                        <footer>ІЦ УАК</footer>
                                    </blockquote>
                                </li>
                                <li aria-hidden="true" style="float: left; list-style: none; position: relative; width: 555px;">
                                    <blockquote class="blockquote-color">
                                        <p>АСТАРТА впевнено розпочала новий сезон виробництва цукру та завершила два інвестиційні проекти з розширення потужностей по зберіганню врожаю.</p>
                                        <footer>Віктор Іванчик, генеральний директор «Астарта-Київ»</footer>
                                    </blockquote>
                                </li>
                                <li aria-hidden="true" style="float: left; list-style: none; position: relative; width: 555px;">
                                    <blockquote class="blockquote-color">
                                        <p>«Астарта» совершенствует модель работы в биоэнергетическом направлении. Генерация и передача 12 МВт электроэнергии в местные сети позволит существенно разгрузить устаревшую местную Глобинский РЭС мощностью 50 МВт.</p>
                                        <footer>AgroPortal.ua</footer>
                                    </blockquote>
                                </li>
                                <li style="float: left; list-style: none; position: relative; width: 555px;" aria-hidden="true">
                                    <blockquote class="blockquote-color">
                                        <p>Агропромисловий холдинг АСТАРТА дбає про покращення умов життя сільських та міських громад, з якими співпрацює.</p>
                                        <footer>Центр розвитку КСВ в Україні</footer>
                                    </blockquote>
                                </li>
                            </ul></div><div class="bx-controls"></div></div>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-xs-6"><img src="/astarta-portal/resources/img/bv1.jpg" alt="" class="img-responsive"></div>
                                <div class="col-md-3 col-sm-3 col-xs-6"><img src="/astarta-portal/resources/img/csr1.jpg" alt="" class="img-responsive"></div>
                                <div class="col-md-3 col-sm-3 col-xs-6"><img src="/astarta-portal/resources/img/vynbytbyi1.jpg" alt="" class="img-responsive"></div>
                                <div class="col-md-3 col-sm-3 col-xs-6"><img src="/astarta-portal/resources/img/gc_un1.jpg" alt="" class="img-responsive"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 col-sm-3 col-xs-6"><img src="/astarta-portal/resources/img/usubc1.jpg" alt="" class="img-responsive"></div>
                                <div class="col-md-3 col-sm-3 col-xs-6"><img src="/astarta-portal/resources/img/eba_logo_jpg1.jpg" alt="" class="img-responsive"></div>
                            </div>
                        </div>
                    </div>
                </section>

            </div> <!-- container -->
`;

var portalFooter = `<aside id="footer-widgets">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <h3 class="footer-widget-title">Карта сайту</h3>
                            <ul class="list-unstyled three_cols">
                                <li><a href="index.html">Головна</a></li>
                                <li><a href="blog.html">Блог</a></li>
                                <li><a href="portfolio_sidebar.html">Профіль</a></li>
                                <li><a href="portfolio_topvar.html">Робота</a></li>
                                <!-- <li><a href="page_timeline_left.html">Timeline</a></li>-->
                                <li><a href="page_pricing.html">Ціни</a></li>
                                <li><a href="page_about2.html">Про нас</a></li>
                                <li><a href="page_team.html">Наша команда</a></li>
                                <li><a href="page_services.html">Сервіс</a></li>
                                <li><a href="page_support.html">FAQ</a></li>
                                <li><a href="page_login_full.html">Login</a></li>
                                <li><a href="page_contact.html">Контакти</a></li>
                            </ul>
                            <h3 class="footer-widget-title">Підписатись</h3>
                            <p>Розсилка дає змогу отримавути цікаву та корисну інформацію. Ви можете слідкувати за новинами компанії. </p>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Ваш Email">
                                <span class="input-group-btn">
                            <button class="btn btn-ar btn-primary" type="button">Підписатись</button>
                        </span>
                            </div><!-- /input-group -->
                        </div>
                        <div class="col-md-4">
                            <div class="footer-widget">
                                <h3 class="footer-widget-title">Недавні повідомлення</h3>
                                <div class="media">
                                    <a class="pull-left" href="#"><img class="media-object" src="/astarta-portal/resources/img/user-ico.png" width="75" height="75" alt="image"></a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="#">Привітання з новорічними святами від керівництва компанії. </a></h4>
                                        <small>20.12.2016</small>
                                    </div>
                                </div>
                                <div class="media">
                                    <a class="pull-left" href="#"><img class="media-object" src="/astarta-portal/resources/img/user-ico.png" width="75" height="75" alt="image"></a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="#">Фінансовий департамент вітає всіх з новим 2017 роком. </a></h4>
                                        <small>20.12.2016</small>
                                    </div>
                                </div>
                                <div class="media">
                                    <a class="pull-left" href="#"><img class="media-object" src="/astarta-portal/resources/img/user-ico.png" width="75" height="75" alt="image"></a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="#">Як ми працюємо на новорічні свята.</a></h4>
                                        <small>15.12.2016</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="footer-widget">
                                <h3 class="footer-widget-title">Останні документи</h3>
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-3 col-xs-6">
                                         <a href="#" class="thumbnail"><img src="/astarta-portal/resources/img/recentdoc1.jpg" class="img-responsive" alt="Image"></a>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-3 col-xs-6">
                                         <a href="#" class="thumbnail"><img src="/astarta-portal/resources/img/recentdoc2.jpg" class="img-responsive" alt="Image"></a>
                                    </div>
                                    <!--<div class="col-lg-6 col-md-6 col-sm-3 col-xs-6">
                                        &lt;!&ndash;<a href="#" class="thumbnail"><img src="" class="img-responsive" alt="Image"></a>&ndash;&gt;
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-3 col-xs-6">
                                        &lt;!&ndash; <a href="#" class="thumbnail"><img src="" class="img-responsive" alt="Image"></a>&ndash;&gt;
                                    </div>-->
                                </div>
                            </div>
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </aside> <!-- footer-widgets -->
            <footer id="footer">
                <p>© 2016 <a href="#">Astarta-Kyiv</a></p>
            </footer>
 `;

/*USER INFO CATEGORY->*/
var userInfoPanel = `
                <div class="container">
                <section class="margin-bottom">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 id="go-to-category-h2" class="right-line">Звіти:</h2>
                        </div>
                        <div class="col-md-4 col-sm-6 report">
                            <div class="text-icon wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;">
                                <span class="icon-ar icon-ar-md"><i class="fa fa-cloud"></i></span>
                                <div class="text-icon-content">
                                    <button type="button" class="btn-link btn-category" onclick="reportPanel.openReportPanel('payslip')"><span id="user-info-label" class="category-label">Відомості по зарплаті.</span></button>
                                    <!--<h4 id="user-info-h3" class="no-margin">Відомості по зарплаті</h4>-->
                                    <!--<p class="open-category"></p>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                </div>       
`;
/*<-USER INFO CATEGORY*/

var paySlipRepPanel = `
                <div class="container">
                <section class="margin-bottom">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 id="go-to-category-h2" class="right-line">Відомість по заробітній платі:</h2>
                        </div>
                        
                        <button id="yearVal-prev" type="button" class="btn-link"><i class="fa fa-chevron-left" aria-hidden="true"></i></button>
                            <span id="yearVal-text">${yearVal}</span>
                       <button id="yearVal-next" type="button" class="btn-link"><i class="fa fa-chevron-right" aria-hidden="true"></i></button>
                       <select id="sel-payslip-cal" type="text" required="required"></select>
                       <select id="sel-payslip-comp" type="text" required="required"></select>
                        <span class="input-group-btn"  style="display: inline;">
                            <button id="showPaySlipBtn" class="btn btn-ar btn-primary" type="button">Показати</button>
                        </span>
                    </div>
                    <div id="report-workspace" class="row">
                    </div> 
                </section>
                </div>
`;

var reportPanelHTMLMap = {
    "payslip": paySlipRepPanel
};

var resPanelHTMLMap = {
    "userInfo": userInfoPanel,
    "albom": "",
    "meetingRoomReserve": "",
    "officialCarsReserve": "",
    "multicastMessages": "",
    "documentsRegistration": "",
    "conflictSurvey": "",
    "conferenceCalls": "",
    "companyDocuments": ""
}


/*const tmpl = addrs => `
    <table>
    ${addrs.map(addr => `
        <tr><td>${addr.first}</td></tr>
        <tr><td>${addr.last}</td></tr>
    `).join('')}
    </table>
`;


const data = [
    { first: '', last: 'Bond' },
    { first: 'Lars', last: '' },
];
console.log(tmpl(data));*/
// Output:
// <table>
//
//     <tr><td><Jane></td></tr>
//     <tr><td>Bond</td></tr>
//
//     <tr><td>Lars</td></tr>
//     <tr><td><Croft></td></tr>
//
// </table>